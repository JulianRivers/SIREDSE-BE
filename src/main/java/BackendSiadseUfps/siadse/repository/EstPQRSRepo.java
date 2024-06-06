package BackendSiadseUfps.siadse.repository;

import BackendSiadseUfps.siadse.entity.EstadosPQRS;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaz de repositorio para acceder a los estados de PQRS en la base de datos.
 * Proporciona métodos para realizar operaciones CRUD en la tabla "estados_pqrs".
 */
public interface EstPQRSRepo extends JpaRepository<EstadosPQRS, Integer> {

    /**
     * Busca un estado de PQRS por su nombre.
     *
     * @param estado Nombre del estado de PQRS a buscar.
     * @return El estado de PQRS encontrado, o null si no se encuentra.
     */
    EstadosPQRS findByEstado(String estado);
}