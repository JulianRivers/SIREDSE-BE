package BackendSiadseUfps.siadse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import BackendSiadseUfps.siadse.entity.Configuracion;

@Repository
<<<<<<< HEAD
public interface ConfiguracionRepository extends JpaRepository<Configuracion, Integer > {
=======
public interface ConfiguracionRepository extends JpaRepository<Configuracion, String> {
>>>>>>> a37ec885e7975e2cc4292fb76b191a78432272b3
}
