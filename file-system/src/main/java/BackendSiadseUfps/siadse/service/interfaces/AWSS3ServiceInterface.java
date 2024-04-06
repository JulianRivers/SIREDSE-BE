package BackendSiadseUfps.siadse.service.interfaces;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import BackendSiadseUfps.siadse.entity.Album;
import org.springframework.web.multipart.MultipartFile;

public interface AWSS3ServiceInterface {

    void uploadFile(MultipartFile file);

    List<String> getObjectsFromS3();

    InputStream downloadFile(String key);

    void createFolder(String folderName);

    String uploadFileToAlbum(MultipartFile file, Album album) throws IOException;
    String getFileUrl(String key);
}