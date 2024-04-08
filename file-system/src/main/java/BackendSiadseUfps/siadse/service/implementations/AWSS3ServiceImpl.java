package BackendSiadseUfps.siadse.service.implementations;
import BackendSiadseUfps.siadse.dto.ContenidoMutimediaDTO;
import BackendSiadseUfps.siadse.entity.Album;
import BackendSiadseUfps.siadse.service.interfaces.AWSS3Service;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AWSS3ServiceImpl implements AWSS3Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(AWSS3ServiceImpl.class);

    @Autowired
    private AmazonS3 amazonS3;

    @Value("${aws.s3.bucket}")
    private String bucketName;

    @Override
    public ContenidoMutimediaDTO uploadFile(MultipartFile file, String ruta) {
        String fileName = file.getOriginalFilename();
        File mainFile = new File(fileName);
        try (FileOutputStream stream = new FileOutputStream(mainFile)) {
            stream.write(file.getBytes());
            String newFileName = ruta + "/" + System.currentTimeMillis() + "_" + fileName; // Concatenar la ruta personalizada
            LOGGER.info("Subiendo archivo con el nombre... " + newFileName);
            PutObjectRequest request = new PutObjectRequest(bucketName, newFileName, mainFile);
            amazonS3.putObject(request);
            ContenidoMutimediaDTO contenidoMultimediaDTO = new ContenidoMutimediaDTO();
            contenidoMultimediaDTO.setTitulo(fileName);
            contenidoMultimediaDTO.setUrl(getFileUrl(newFileName));
            contenidoMultimediaDTO.setKeyFile(newFileName);
            return contenidoMultimediaDTO;
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
            return null;
        }
    }


    @Override
    public List<String> getObjectsFromS3() {
        ListObjectsV2Result result = amazonS3.listObjectsV2(bucketName);
        List<S3ObjectSummary> objects = result.getObjectSummaries();
        return objects.stream()
                .map(S3ObjectSummary::getKey)
                .collect(Collectors.toList());
    }

    @Override
    public InputStream downloadFile(String key) {
        S3Object object = amazonS3.getObject(bucketName, key);
        return object.getObjectContent();
    }

    @Override
    public void createFolder(String folderName) {
        if (!amazonS3.doesObjectExist(bucketName, folderName + "/")) {
            amazonS3.putObject(bucketName, folderName + "/", "");
        }
    }

    @Override
    public String uploadFileToAlbum(MultipartFile file, Album album) throws IOException {
        File mainFile = convertMultiPartFileToFile(file);
        try (FileOutputStream stream = new FileOutputStream(mainFile)) {
            stream.write(file.getBytes());
            String newFileName = album.getUbicacionS3() + "/" + System.currentTimeMillis() + "_" + mainFile.getName();
            PutObjectRequest request = new PutObjectRequest(bucketName, newFileName, mainFile);
            amazonS3.putObject(request);
            return newFileName;
        } catch (IOException e) {
            throw new IOException("Error al subir el archivo a S3: " + e.getMessage());
        } finally {
            if (mainFile.exists()) {
                mainFile.delete();
            }
        }
    }

    @Override
    public String getFileUrl(String key) {
        return amazonS3.getUrl(bucketName, key).toString();
    }

    private File convertMultiPartFileToFile(MultipartFile file) throws IOException {
        File convertedFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(file.getBytes());
        }
        return convertedFile;
    }

    @Override
    public void deleteFolder(String folderName) {
        // Eliminar todos los objetos dentro de la carpeta
        ObjectListing objectListing = amazonS3.listObjects(bucketName, folderName);
        for (S3ObjectSummary objectSummary : objectListing.getObjectSummaries()) {
            amazonS3.deleteObject(bucketName, objectSummary.getKey());
        }
        // Eliminar la carpeta
        amazonS3.deleteObject(bucketName, folderName + "/");
    }

    @Override
    public void deleteFile(String key) {
        amazonS3.deleteObject(bucketName, key);
    }
}
