package BackendSiadseUfps.siadse.repository;

import BackendSiadseUfps.siadse.entity.EstadosSoli;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EstadosSoliRepo extends JpaRepository<EstadosSoli, Integer>{
    EstadosSoli findByEstado (String estado);
}
