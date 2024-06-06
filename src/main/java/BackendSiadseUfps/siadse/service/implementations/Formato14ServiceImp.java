package BackendSiadseUfps.siadse.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BackendSiadseUfps.siadse.entity.Formato14;
import BackendSiadseUfps.siadse.repository.Formato14Repository;
import BackendSiadseUfps.siadse.service.interfaces.Formato14Service;

@Service
public class Formato14ServiceImp implements Formato14Service{
	
	 @Autowired
	    private Formato14Repository formato14Repository;

	    @Override
	    public Optional<Formato14> findById(Integer id) {
	        return formato14Repository.findById(id);
	    }

	    @Override
	    public String getNombreProyecto(Formato14 formato) {
	        return formato.getProyecto().getProjectName();
	    }

	    @Override
	    public String getNombreSemillero(Formato14 formato) {
	        return formato.getSemillero().getNombre();
	    }

	    @Override
	    public String getNombreDirector(Formato14 formato) {
	        return formato.getDirector().getName();
	    }

//	    @Override
//	    public List<String> getCapacitaciones(Formato14 formato) {
//	        return formato.getCapacitaciones();
//	    }

		@Override
		public String getNombreliderProyecto(Formato14 formato) {
			// TODO Auto-generated method stub
			return formato.getProyecto().getProjectLeader().getName();
		}

		@Override
		public String getEmailLiderProyecto(Formato14 formato) {
			// TODO Auto-generated method stub
			return formato.getProyecto().getProjectLeader().getEmail();
		}
		
		@Override
	    public List<Formato14> findAll() {
	        return formato14Repository.findAll();
	    }

		@Override
	    public Formato14 save(Formato14 formato14) {
	        return formato14Repository.save(formato14);
	    }
}
