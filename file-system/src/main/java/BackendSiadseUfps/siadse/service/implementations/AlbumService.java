package BackendSiadseUfps.siadse.service.implementations;

import BackendSiadseUfps.siadse.dto.AlbumDTO;
import BackendSiadseUfps.siadse.entity.Album;
import BackendSiadseUfps.siadse.repository.AlbumRepository;
import BackendSiadseUfps.siadse.service.interfaces.AlbumServiceInterface;
import BackendSiadseUfps.siadse.service.interfaces.AWSS3ServiceInterface;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AlbumService implements AlbumServiceInterface {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private AWSS3ServiceInterface awss3Service;

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
}
