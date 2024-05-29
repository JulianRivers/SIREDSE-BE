package BackendSiadseUfps.siadse.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import BackendSiadseUfps.siadse.entity.Capacitaciones;
import BackendSiadseUfps.siadse.entity.User;



public interface CapacitacionesRepository extends JpaRepository<User, Integer> {
	  Optional<Capacitaciones> buscarCapacitacionesPorId(Capacitaciones integer);
	  
	    Capacitaciones buscarCapacitacionesPorId(Integer id);
}
