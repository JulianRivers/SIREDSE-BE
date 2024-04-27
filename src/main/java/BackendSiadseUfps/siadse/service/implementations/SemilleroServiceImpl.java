package BackendSiadseUfps.siadse.service.implementations;

import BackendSiadseUfps.siadse.dto.SemilleroDTO;
import BackendSiadseUfps.siadse.entity.Semillero;
import BackendSiadseUfps.siadse.repository.SemilleroRepository;
import BackendSiadseUfps.siadse.service.interfaces.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SemilleroServiceImpl implements SemilleroService {

    private final ModelMapper modelMapper;
    private final SemilleroRepository semilleroRepository;

    public SemilleroServiceImpl(ModelMapper modelMapper, SemilleroRepository semilleroRepository) {
        this.modelMapper = modelMapper;
        this.semilleroRepository = semilleroRepository;

    }

    @Override
    public SemilleroDTO crearSemillero(SemilleroDTO semilleroDTO) {
        Semillero semillero = modelMapper.map(semilleroDTO, Semillero.class);
        semillero.setFechaCreacion(new Date());
        semillero.setFechaActualizacion(semillero.getFechaCreacion());
        semillero = semilleroRepository.save(semillero);
        return modelMapper.map(semillero, SemilleroDTO.class);
    }
}