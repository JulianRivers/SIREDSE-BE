package BackendSiadseUfps.siadse.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 */
@Entity
@Data
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private long codigo;
    private String semestre;
    private int edad;
    private boolean activo = true;
    private String celular;
    private String direccion;
    

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "usuario")
    @JsonIgnore
    private Set<UsuarioRol> usuarioRoles = new HashSet<>();

    public Usuario(){

    }

	public Usuario(Long id, String name, String email, String password, long codigo, String semestre, int edad,
			boolean activo, String celular, String direccion, Set<UsuarioRol> usuarioRoles) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.codigo = codigo;
		this.semestre = semestre;
		this.edad = edad;
		this.activo = activo;
		this.celular = celular;
		this.direccion = direccion;
		this.usuarioRoles = usuarioRoles;
	}
    
    
}

   

   
