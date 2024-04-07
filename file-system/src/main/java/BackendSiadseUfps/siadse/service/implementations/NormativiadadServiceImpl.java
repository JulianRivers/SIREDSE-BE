package BackendSiadseUfps.siadse.service.implementations;

import BackendSiadseUfps.siadse.dto.ContenidoMutimediaDTO;
import BackendSiadseUfps.siadse.repository.AlbumRepository;
import BackendSiadseUfps.siadse.service.interfaces.AWSS3ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Service
public class NormativiadadServiceImpl implements BackendSiadseUfps.siadse.service.interfaces.NormatividadService {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private AWSS3ServiceInterface awss3Service;

    @Override
    public ContenidoMutimediaDTO upload(Integer albumId, String titulo, MultipartFile file) throws IOException {
        return null;
    }
}