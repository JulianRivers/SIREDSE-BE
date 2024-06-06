package BackendSiadseUfps.siadse.repository;


import BackendSiadseUfps.siadse.entity.EstadosPQRS;
import BackendSiadseUfps.siadse.entity.PQRS;
import BackendSiadseUfps.siadse.entity.TiposPQRS;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repositorio para la entidad PQRS.
 *
 * Este repositorio proporciona métodos para realizar operaciones de consulta y persistencia en la tabla PQRS en la base de datos.
 */
public interface PQRSRepo extends JpaRepository<PQRS, Integer> {

    /**
     * Busca y devuelve una lista de PQRS que tienen el tipo de PQRS especificado.
     *
     * @param tiposPqrs El tipo de PQRS a buscar.
     * @return Una lista de PQRS que tienen el tipo de PQRS especificado.
     */
    List<PQRS> findByTipoPqrs(TiposPQRS tiposPqrs);

    /**
     * Busca y devuelve una lista de PQRS que tienen el estado de radicado especificado.
     *
     * @param estadosPQRS El estado de radicado a buscar.
     * @return Una lista de PQRS que tienen el estado de radicado especificado.
     */
    List<PQRS> findByEstadoRadicado(EstadosPQRS estadosPQRS);

    /**
     * Busca y devuelve el PQRS con el código de radicado especificado.
     *
     * @param codigoRadicado El código de radicado a buscar.
     * @return El PQRS con el código de radicado especificado, o null si no se encuentra.
     */
    PQRS findByCodigoRadicado(String codigoRadicado);
}
