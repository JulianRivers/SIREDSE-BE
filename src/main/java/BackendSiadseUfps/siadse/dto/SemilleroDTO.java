package BackendSiadseUfps.siadse.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SemilleroDTO {
    private Integer id;
    private String nombre;
    private String descripcion;
    private String codigo; // Asegúrate de que el DTO también tenga el campo "codigo"
    private DirectorDTO director;
}
