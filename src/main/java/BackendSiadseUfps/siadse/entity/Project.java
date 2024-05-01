package BackendSiadseUfps.siadse.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String projectName;
    
    private String archivo ;
    
    private String imagen="no-image.png";
    
    @OneToOne
	@JoinColumn(name = "idCategoria") // foreignKey en la tabla de Vacantes	
	private Categoria categoria; 
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User projectLeader;  // Líder del proyecto, supongamos que es un User con roleId = 3
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "semillero_id")
    private Semillero semillero;
}
