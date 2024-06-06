package BackendSiadseUfps.siadse.repository;

import BackendSiadseUfps.siadse.entity.TiposPQRS;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaz de repositorio para acceder a los tipos de PQRS en la base de datos.
 * Proporciona métodos para realizar operaciones CRUD en la tabla "Tipos_PQRS".
 */
public interface TipoPQRSRepo extends JpaRepository<TiposPQRS, Integer> {

    /**
     * Busca un tipo de PQRS por su nombre.
     *
     * @param tipo Nombre del tipo de PQRS a buscar.
     * @return El tipo de PQRS encontrado, o null si no se encuentra.
     */
    TiposPQRS findByTipo(String tipo);
}
