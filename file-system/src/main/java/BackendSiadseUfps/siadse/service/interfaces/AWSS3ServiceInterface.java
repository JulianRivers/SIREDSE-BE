package BackendSiadseUfps.siadse.service.interfaces;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import BackendSiadseUfps.siadse.dto.ContenidoMutimediaDTO;
import BackendSiadseUfps.siadse.entity.Album;
import BackendSiadseUfps.siadse.entity.Normatividad;
import org.springframework.web.multipart.MultipartFile;

public interface AWSS3ServiceInterface {

    ContenidoMutimediaDTO uploadFile(MultipartFile file, String ruta);

    List<String> getObjectsFromS3();

    InputStream downloadFile(String key);

    void createFolder(String folderName);

    String uploadFileToAlbum(MultipartFile file, Album album) throws IOException;
    String getFileUrl(String key);

}