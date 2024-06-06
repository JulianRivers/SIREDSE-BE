package BackendSiadseUfps.siadse.controller;



import BackendSiadseUfps.siadse.dto.PQRSDTO;
import BackendSiadseUfps.siadse.models.Response;
import BackendSiadseUfps.siadse.service.implementations.PQRSService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para gestionar las operaciones relacionadas con las solicitudes PQRS.
 */
@RestController
@RequestMapping("/pqrs") //Aca no se deja el request si manejan doble rol por url, sino en los propios métodos el mapping se deja el rol
public class PQRSController {

    @Autowired
    PQRSService pqrsService;

    /**
     * Crea una nueva solicitud PQRS.
     *
     * @param pqrsDTO Datos de la solicitud PQRS a crear.
     * @param tipoPQRSID ID del tipo de PQRS.
     * @return La solicitud PQRS creada.
     */
    @PostMapping("/create")
    public ResponseEntity<PQRSDTO> createRequest(@RequestBody PQRSDTO pqrsDTO, @RequestParam Integer tipoPQRSID) {

        PQRSDTO newPQRS = pqrsService.createPQRS(pqrsDTO, tipoPQRSID);

        return ResponseEntity.ok(newPQRS);
    }

    /**
     * Responde a una solicitud PQRS.
     *
     * @param mensaje Mensaje de respuesta.
     * @param pqrsId ID de la solicitud PQRS a responder.
     * @return El mensaje de respuesta enviado.
     */
    @PostMapping("/respuesta")
    public ResponseEntity<String> respuestaPQR(@RequestBody String mensaje, @RequestParam Integer pqrsId) {
        pqrsService.respuestaPQRS(pqrsId, mensaje);
        return ResponseEntity.ok(mensaje);
    }

    /**
     * Obtiene una solicitud PQRS por su ID.
     *
     * @param pqrsId ID de la solicitud PQRS.
     * @return La solicitud PQRS encontrada.
     */
    @GetMapping("/{pqrsId}")
    public ResponseEntity<PQRSDTO> listPQRbyId(@PathVariable Integer pqrsId) {
        PQRSDTO pqrsdto = new PQRSDTO();
        BeanUtils.copyProperties(pqrsService.listarPQRSporId(pqrsId), pqrsdto);
        return ResponseEntity.ok(pqrsdto);
    }

    /**
     * Obtiene una solicitud PQRS por su código de radicación.
     *
     * @param codeRad Código de radicación de la solicitud PQRS.
     * @return La solicitud PQRS encontrada.
     */
    @GetMapping("/code/{codeRad}")
    public ResponseEntity<PQRSDTO> listPQRbyCodeRad(@PathVariable String codeRad) {
        PQRSDTO pqrsdto = new PQRSDTO();
        BeanUtils.copyProperties(pqrsService.listarByRadCode(codeRad), pqrsdto);
        return ResponseEntity.ok(pqrsdto);
    }

    /**
     * Lista todas las solicitudes PQRS.
     *
     * @return Una lista de todas las solicitudes PQRS.
     */
    @GetMapping
    public List<PQRSDTO> listarPQRSr() {
        return pqrsService.listarPQRS();
    }

    /**
     * Lista las solicitudes PQRS por tipo.
     *
     * @param tipo ID del tipo de PQRS.
     * @return Una lista de las solicitudes PQRS del tipo especificado.
     */
    @GetMapping("/tipo")
    public List<PQRSDTO> listarPqrsTipo(@RequestParam Integer tipo) {
        return pqrsService.listarPQRSporTipo(tipo);
    }

    /**
     * Lista las solicitudes PQRS por estado.
     *
     * @param estado ID del estado de PQRS.
     * @return Una lista de las solicitudes PQRS con el estado especificado.
     */
    @GetMapping("/estado")
    public List<PQRSDTO> listarPqrsEstado(@RequestParam Integer estado) {
        return pqrsService.listarPQRSporEstado(estado);
    }

    /**
     * Elimina una solicitud PQRS.
     *
     * @param pqrsID ID de la solicitud PQRS a eliminar.
     * @return `true` si la solicitud PQRS fue eliminada, `false` en caso contrario.
     */
    @DeleteMapping("/delete")
    public Boolean deletePQRS(@RequestParam Integer pqrsID){
        return  pqrsService.eliminarPQRS(pqrsID);
    }

    /**
     * Cambia el estado de una solicitud PQRS a "Revisión".
     *
     * @param pqrsId ID de la solicitud PQRS.
     * @return Una respuesta indicando el resultado de la operación.
     */
    @PostMapping("/revision")
    public Response reviewPQRS(@RequestParam Integer pqrsId) {
        Response response = new Response();
        try {
            pqrsService.cambioEstadoPQRS(pqrsId, 2);
            response.setMessage("PQRS pasada a Revision");
        } catch (IllegalArgumentException e) {
            response.setMessage("Error cambiando el estado: " + e.getMessage());
        }

        return response;
    }

    /**
     * Cambia el estado de una solicitud PQRS a "Resuelto".
     *
     * @param pqrsId ID de la solicitud PQRS.
     * @return Una respuesta indicando el resultado de la operación.
     */
    @PostMapping("/resuelto")
    public Response finishPQRS(@RequestParam Integer pqrsId) {
        Response response = new Response();
        try {
            pqrsService.cambioEstadoPQRS(pqrsId, 3);
            response.setMessage("PQRS Resuelta");
        } catch (IllegalArgumentException e) {
            response.setMessage("Error cambiando el estado: " + e.getMessage());
        }

        return response;
    }

}
