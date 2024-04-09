package BackendSiadseUfps.siadse.service.implementations;

import BackendSiadseUfps.siadse.dto.AlbumDTO;
import BackendSiadseUfps.siadse.entity.Album;
import BackendSiadseUfps.siadse.entity.ContenidoMultimedia;
import BackendSiadseUfps.siadse.repository.AlbumRepository;
import BackendSiadseUfps.siadse.repository.ContenidoMultimediaRepository;
import BackendSiadseUfps.siadse.service.interfaces.AlbumService;
import BackendSiadseUfps.siadse.service.interfaces.AWSS3Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private AWSS3Service awss3Service;

    @Autowired
    private ContenidoMultimediaRepository contenidoMultimediaRepository;

    @Override
    public AlbumDTO createAlbum(AlbumDTO albumDTO) {

        Album album = new Album();
        album.setTitulo(albumDTO.getTitulo());
        album.setDescripcion(albumDTO.getDescripcion());
        album.setFechaCreacion(new Date());
        album.setFechaActualizacion(new Date());
        album = albumRepository.save(album);

        String albumFolderName = album.getTitulo();
        awss3Service.createFolder(albumFolderName);

        album.setUbicacionS3(albumFolderName);
        album = albumRepository.save(album);
        BeanUtils.copyProperties(album, albumDTO);
        return albumDTO;
    }

    @Override
    public void deleteAlbum(Integer albumId) {
        Optional<Album> optionalAlbum = albumRepository.findById(albumId);
        if (optionalAlbum.isPresent()) {
            Album album = optionalAlbum.get();
            String albumFolderName = album.getUbicacionS3();

            List<ContenidoMultimedia> multimediaList = contenidoMultimediaRepository.findByAlbumId(albumId);
            for (ContenidoMultimedia multimedia : multimediaList) {
                awss3Service.deleteFile(multimedia.getKeyFile());
                contenidoMultimediaRepository.delete(multimedia);
            }

            awss3Service.deleteFolder(albumFolderName);

            albumRepository.delete(album);
        } else {
            throw new IllegalArgumentException("No se encontró el álbum con el ID especificado");
        }
    }
}
