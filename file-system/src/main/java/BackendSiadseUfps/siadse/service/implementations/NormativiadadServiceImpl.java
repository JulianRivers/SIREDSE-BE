package BackendSiadseUfps.siadse.service.implementations;

import BackendSiadseUfps.siadse.dto.ContenidoMutimediaDTO;
import BackendSiadseUfps.siadse.dto.NormatividadDTO;
import BackendSiadseUfps.siadse.entity.Normatividad;
import BackendSiadseUfps.siadse.entity.Semillero;
import BackendSiadseUfps.siadse.repository.AlbumRepository;
import BackendSiadseUfps.siadse.repository.NormatividadRepository;
import BackendSiadseUfps.siadse.repository.SemilleroRepository;
import BackendSiadseUfps.siadse.service.interfaces.AWSS3ServiceInterface;
import BackendSiadseUfps.siadse.service.interfaces.NormatividadService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;


@Service
public class NormativiadadServiceImpl implements NormatividadService {
    private NormatividadRepository normatividadRepository;
    private SemilleroRepository semilleroRepository;
    private final ModelMapper modelMapper;
    private AWSS3ServiceInterface awss3Service;

    public NormativiadadServiceImpl( SemilleroRepository semilleroRepository, ModelMapper modelMapper, AWSS3ServiceInterface awss3Service, NormatividadRepository normatividadRepository) {
        this.semilleroRepository = semilleroRepository;
        this.modelMapper = modelMapper;
        this.awss3Service = awss3Service;
        this.normatividadRepository = normatividadRepository;
    }

    public NormatividadDTO upload(Integer semilleroId, MultipartFile file) throws IOException {
        Semillero semillero = semilleroRepository.getReferenceById(semilleroId);

        if (semillero == null || semillero.getNombre() == null) {
            throw new IllegalStateException("No se puede obtener el semillero con ID: " + semilleroId);
        }
        String ruta = "Normatividad/" + semillero.getNombre();
        awss3Service.createFolder(ruta);
        ContenidoMutimediaDTO contenidoMultimediaDTO = awss3Service.uploadFile(file,ruta );
        Normatividad normatividad = modelMapper.map(contenidoMultimediaDTO, Normatividad.class);
        normatividad.setFechaSubida(new Date());
        normatividad.setFormato(obtenerFormatoArchivo(file.getOriginalFilename()));
        normatividad.setSemillero(semillero);
        Normatividad savedNormatividad = normatividadRepository.save(normatividad);
        NormatividadDTO normatividadDTO = modelMapper.map(savedNormatividad, NormatividadDTO.class);
        return normatividadDTO;
    }


    private String obtenerFormatoArchivo(String fileName) {
        int index = fileName.lastIndexOf('.');
        if (index > 0) {
            return fileName.substring(index + 1);
        }
        return "";
    }
    }

