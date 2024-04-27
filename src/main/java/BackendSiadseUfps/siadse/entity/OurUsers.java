package BackendSiadseUfps.siadse.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.lang.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@Getter
@Entity
@Table(name = "ourusers")
public class OurUsers implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "email cannot be null")
    @Size(min = 1, max = 255)
    private String email;
    @NotNull(message = "passwod cannot be null")
    @Size(min = 6, max = 255)
    private String password;
    @NotNull(message = "Role cannot be null")
    private String role;
    @NotNull(message = "codigoU cannot be null")
    @Size(min = 1, max = 255)
    private String codigoUniversidad;
    @NotNull(message = "semestreActual cannot be null")
    @Min(1)
    @Max(85)
    private Integer semestreActual;
    @NotNull(message = "edad cannot be null")
    @Min(16)
    private Integer edad;
    @NotNull(message = "Direccion cannot be null")
    @Size(min = 1, max = 255)
    private String direccionResidencia;
    @NotNull(message = "celular cannot be null")
    @Size(min = 1, max = 15)
    private String celular;
     
    private boolean directorSemilleros;
    
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));
        
        // Si el usuario es director de semilleros, agregamos el rol correspondiente
        if (directorSemilleros) {
            authorities.add(new SimpleGrantedAuthority("ROLE_DIRECTOR_SEMILLEROS"));
        }
        
        return authorities;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCodigoUniversidad() {
        return codigoUniversidad;
    }

    public void setCodigoUniversidad(String codigoUniversidad) {
        this.codigoUniversidad = codigoUniversidad;
    }

    public Integer getSemestreActual() {
        return semestreActual;
    }

    public void setSemestreActual(Integer semestreActual) {
        this.semestreActual = semestreActual;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getDireccionResidencia() {
        return direccionResidencia;
    }

    public void setDireccionResidencia(String direccionResidencia) {
        this.direccionResidencia = direccionResidencia;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public boolean isDirectorSemilleros() {
        return directorSemilleros;
    }

    public void setDirectorSemilleros(boolean directorSemilleros) {
        this.directorSemilleros = directorSemilleros;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}