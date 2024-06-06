package BackendSiadseUfps.siadse.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import BackendSiadseUfps.siadse.entity.Configuracion;

@Repository
public interface ConfiguracionRepository extends JpaRepository<Configuracion, Integer> {
	
	Optional<Configuracion> findById(String id);
	
	void deleteById(String id);
}
