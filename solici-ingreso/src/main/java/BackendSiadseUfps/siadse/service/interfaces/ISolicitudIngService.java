package BackendSiadseUfps.siadse.service.interfaces;

import BackendSiadseUfps.siadse.dto.SolicitudIngDTO;

import java.util.List;

public interface ISolicitudIngService {

    public SolicitudIngDTO createSolicitud(Integer userID, Integer semilleroID);
    public List<SolicitudIngDTO> listarSolicitudes();
    public void cambioEstadoSolicitud(Integer solicitudID, Integer nuevoEstadoID);
    public List<SolicitudIngDTO> listarSolicitudporEstado(Integer estadoID);


}
