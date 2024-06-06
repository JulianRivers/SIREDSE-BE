package BackendSiadseUfps.siadse.service.interfaces;

import java.util.List;
import java.util.Optional;

import BackendSiadseUfps.siadse.entity.Formato14;

public interface Formato14Service {
	
	Optional<Formato14> findById(Integer id);
    String getNombreProyecto(Formato14 formato);
    String getNombreSemillero(Formato14 formato);
    String getNombreDirector(Formato14 formato);
    String getNombreliderProyecto(Formato14 formato);
    String getEmailLiderProyecto(Formato14 formato);
   // List<String> getCapacitaciones(Formato14 formato);
	Formato14 save(Formato14 formato14);
	List<Formato14> findAll();

}
