package BackendSiadseUfps.siadse.service.implementations;

import BackendSiadseUfps.siadse.dto.ContenidoMutimediaDTO;
import BackendSiadseUfps.siadse.entity.Album;
import BackendSiadseUfps.siadse.entity.ContenidoMultimedia;
import BackendSiadseUfps.siadse.repository.AlbumRepository;
import BackendSiadseUfps.siadse.repository.ContenidoMultimediaRepository;
import BackendSiadseUfps.siadse.service.interfaces.AWSS3Service;
import BackendSiadseUfps.siadse.service.interfaces.ContenidoMultimediaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContenidoMultimediaServiceImpl implements ContenidoMultimediaService {

    @Autowired
    private ContenidoMultimediaRepository contenidoMultimediaRepository;

    @Autowired
    private AWSS3Service awss3Service;

    @Autowired
    private AlbumRepository albumRepository;

    @Override
    public ContenidoMutimediaDTO createMediaContent(Integer albumId, String titulo, MultipartFile file) throws IOException {
        // Verificar si el álbum existe
        Album album = albumRepository.findById(albumId)
                .orElseThrow(() -> new IllegalArgumentException("No se encontró el álbum con el ID especificado"));

        // Guardar el archivo en S3
        String keyFile = awss3Service.uploadFileToAlbum(file, album);

        ContenidoMultimedia contenidoMultimedia = new ContenidoMultimedia();
        contenidoMultimedia.setTitulo(titulo);
        contenidoMultimedia.setFechaSubida(new Date());
        contenidoMultimedia.setKeyFile(keyFile);
        contenidoMultimedia.setAlbum(album);

        String fileName = file.getOriginalFilename();
        String formato = obtenerFormatoArchivo(fileName);
        contenidoMultimedia.setFormato(formato);

        ContenidoMultimedia savedContenidoMultimedia = contenidoMultimediaRepository.save(contenidoMultimedia);

        savedContenidoMultimedia.setUrl(awss3Service.getFileUrl(keyFile));
        contenidoMultimediaRepository.save(savedContenidoMultimedia);

        album.setFechaActualizacion(new Date());
        albumRepository.save(album);

        // Crear el DTO de respuesta
        ContenidoMutimediaDTO responseDTO = new ContenidoMutimediaDTO();
        responseDTO.setAlbumId(albumId);
        BeanUtils.copyProperties(savedContenidoMultimedia, responseDTO);
        return responseDTO;
    }
    @Override
    public List<ContenidoMutimediaDTO> getMediaContentByAlbum(Integer albumId) {
        List<ContenidoMultimedia> contents = contenidoMultimediaRepository.findByAlbumId(albumId);
        return contents.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteMediaContent(Integer contenidoId) throws IOException {

        ContenidoMultimedia contenidoMultimedia = contenidoMultimediaRepository.findById(contenidoId)
                .orElseThrow(() -> new IllegalArgumentException("No se encontró el contenido multimedia con el ID especificado"));

        awss3Service.deleteFile(contenidoMultimedia.getKeyFile());

        contenidoMultimediaRepository.delete(contenidoMultimedia);
    }

    private ContenidoMutimediaDTO convertToDTO(ContenidoMultimedia contenido) {
        ContenidoMutimediaDTO dto = new ContenidoMutimediaDTO();
        BeanUtils.copyProperties(contenido, dto);
        dto.setAlbumId(contenido.getAlbum().getId());
        return dto;
    }
    private String obtenerFormatoArchivo(String fileName) {
        int index = fileName.lastIndexOf('.');
        if (index > 0) {
            return fileName.substring(index + 1);
        }
        return "";
    }
}