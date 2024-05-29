
package BackendSiadseUfps.siadse.entity;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false, unique = true) // Asegurarse de que el username es único y no nulo
    private String username; 
    
    private String name;
    
    @Column(nullable = false, unique = true) // Asegura que el email es único y no nulo
    private String email;
    
    @Column(nullable = false)
    private String password;
    
    private String codigoUniversidad;
    private int semestreActual;
    private int edad;
    private String direccionResidencia;
    private String celular;
    
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;
    @Column(name = "logged_in")
    private boolean loggedIn;
}
