package BackendSiadseUfps.siadse.service.interfaces;


import BackendSiadseUfps.siadse.dto.PQRSDTO;

import java.util.List;

/**
 * Interfaz para definir los servicios relacionados con las PQRS.
 */
public interface IPQRSService {

    /**
     * Crea un nuevo PQRS.
     *
     * @param pqrsDTO      DTO que contiene la información del PQRS a crear.
     * @param tipoPQRSID   ID del tipo de PQRS asociado.
     * @return             DTO del PQRS creado.
     */
    PQRSDTO createPQRS(PQRSDTO pqrsDTO, Integer tipoPQRSID);

    /**
     * Cambia el estado de un PQRS.
     *
     * @param pqrsID          ID del PQRS a actualizar.
     * @param nuevoEstadoID   ID del nuevo estado del PQRS.
     */
    void cambioEstadoPQRS(Integer pqrsID, Integer nuevoEstadoID);

    /**
     * Obtiene una lista de todos los PQRS.
     *
     * @return Lista de DTOs de los PQRS.
     */
    List<PQRSDTO> listarPQRS();

    /**
     * Obtiene una lista de PQRS filtrados por tipo.
     *
     * @param tipoID   ID del tipo de PQRS a filtrar.
     * @return         Lista de DTOs de los PQRS filtrados por tipo.
     */
    List<PQRSDTO> listarPQRSporTipo(Integer tipoID);

    /**
     * Obtiene una lista de PQRS filtrados por estado.
     *
     * @param estadoID   ID del estado de PQRS a filtrar.
     * @return           Lista de DTOs de los PQRS filtrados por estado.
     */
    List<PQRSDTO> listarPQRSporEstado(Integer estadoID);

    /**
     * Obtiene un PQRS por su ID.
     *
     * @param id   ID del PQRS a obtener.
     * @return     DTO del PQRS encontrado.
     */
    PQRSDTO listarPQRSporId(Integer id);

    /**
     * Elimina un PQRS por su ID.
     *
     * @param pqrsID   ID del PQRS a eliminar.
     * @return         true si se eliminó correctamente, false de lo contrario.
     */
    boolean eliminarPQRS(Integer pqrsID);

    /**
     * Obtiene un PQRS por su código de radicado.
     *
     * @param radCode   Código de radicado del PQRS a obtener.
     * @return          DTO del PQRS encontrado.
     */
    PQRSDTO listarByRadCode(String radCode);

    /**
     * Responde a un PQRS.
     *
     * @param pqrsId    ID del PQRS al que se le va a responder.
     * @param mensaje   Mensaje de respuesta.
     */
    void respuestaPQRS(Integer pqrsId, String mensaje);
}