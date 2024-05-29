package BackendSiadseUfps.siadse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

import java.util.Date;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "semillero")
public class Semillero {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nombre;
	private String descripcion;
	private Date fechaCreacion;
	private Date fechaActualizacion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "director_id", referencedColumnName = "id")
	private User director;  // Asume un User con roleId = 2 para directores

	@OneToMany(mappedBy = "semillero")
	private Set<Project> projects;
}

