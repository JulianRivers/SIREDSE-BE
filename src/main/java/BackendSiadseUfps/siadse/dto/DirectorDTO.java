package BackendSiadseUfps.siadse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DirectorDTO {
    private Integer id;
    private String nombre;
    private String email;

    // Añade más campos si es necesario
}
