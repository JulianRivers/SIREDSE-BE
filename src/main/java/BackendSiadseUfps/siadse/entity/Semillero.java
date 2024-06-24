package BackendSiadseUfps.siadse.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "semillero")
public class Semillero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Size(max = 30, message = "El nombre debe tener como máximo 30 caracteres")
    private String nombre;
    
    @Size(max = 300, message = "La descripción debe tener como máximo 300 caracteres")
    private String descripcion;

    private String codigo; // Asegúrate de que el código sea String si es alfanumérico

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "director_id", referencedColumnName = "id")
    private User director;

    @OneToMany(mappedBy = "semillero")
    private Set<Project> projects;

    @ManyToMany
    @JoinTable(
        name = "semillero_miembros",
        joinColumns = @JoinColumn(name = "semillero_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> miembros = new HashSet<>();
}
