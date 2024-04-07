package BackendSiadseUfps.siadse.service.interfaces;

import BackendSiadseUfps.siadse.dto.ContenidoMutimediaDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ContenidoMultimediaServiceInterface {
    ContenidoMutimediaDTO createMediaContent(Integer albumId, String titulo, MultipartFile file) throws IOException;
}
