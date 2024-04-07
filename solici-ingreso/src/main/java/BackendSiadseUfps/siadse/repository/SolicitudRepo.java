package BackendSiadseUfps.siadse.repository;

import BackendSiadseUfps.siadse.entity.EstadosSoli;
import BackendSiadseUfps.siadse.entity.SolicitudIngresoSemillero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface SolicitudRepo extends JpaRepository<SolicitudIngresoSemillero, Integer> {
    List<SolicitudIngresoSemillero> findByEstado (EstadosSoli estadosSoli);
}
