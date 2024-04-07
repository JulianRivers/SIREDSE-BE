package BackendSiadseUfps.siadse.controller;

import BackendSiadseUfps.siadse.dto.SolicitudIngDTO;
import BackendSiadseUfps.siadse.models.response.Response;
import BackendSiadseUfps.siadse.service.implementations.SolicitudIngService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/solicitud")
public class SolicitudIngAdminController {

    @Autowired
    SolicitudIngService solicitudIngService;


    @GetMapping
    public List<SolicitudIngDTO> listarSolicitudes() {
        return solicitudIngService.listarSolicitudes();
    }

    @GetMapping("/estado")
    public List<SolicitudIngDTO> listarSolicitudesEstado(@RequestParam Integer estado) {
        return solicitudIngService.listarSolicitudporEstado(estado);
    }

    @PostMapping("/approve")
    public Response reviewSolicitud(@RequestParam Integer solicitudID) {
        Response response = new Response();
        try {
            solicitudIngService.cambioEstadoSolicitud(solicitudID, 3);
            response.setMessage("Solicitud Aprobada");
        } catch (IllegalArgumentException e) {
            response.setMessage("Error cambiando el estado: " + e.getMessage());
        }

        return response;
    }

    @PostMapping("/denied")
    public Response finishSolicitud(@RequestParam Integer solicitudID) {
        Response response = new Response();
        try {
            solicitudIngService.cambioEstadoSolicitud(solicitudID, 2);
            response.setMessage("Solicitud Rechazada");
        } catch (IllegalArgumentException e) {
            response.setMessage("Error cambiando el estado: " + e.getMessage());
        }

        return response;
    }

}
