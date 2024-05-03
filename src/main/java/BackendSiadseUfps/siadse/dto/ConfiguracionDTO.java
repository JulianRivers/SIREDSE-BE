package BackendSiadseUfps.siadse.dto;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ConfiguracionDTO {

    @NotNull(message = "El nombre no puede ser nulo")
    @NotBlank(message = "El nombre no puede estar en blanco")
    private String nombre;

    @NotNull(message = "La descripción no puede ser nulo")
    @NotBlank(message = "La descripción no puede estar en blanco")
    private String descripcion;

    @NotNull(message = "La misión no puede ser nulo")
    @NotBlank(message = "La misión no puede estar en blanco")
    private String mision;

    @NotNull(message = "La visión no puede ser nulo")
    @NotBlank(message = "La visión no puede estar en blanco")
    private String vision;

    @NotNull(message = "El departamento no puede ser nulo")
    @NotBlank(message = "El departamento no puede estar en blanco")
    private String departamento;

    @NotNull(message = "El docente no puede ser nulo")
    @NotBlank(message = "El docente no puede estar en blanco")
    private String docente;

    @NotNull(message = "El líder no puede ser nulo")
    @NotBlank(message = "El líder no puede estar en blanco")
    private String lider;



}