package BackendSiadseUfps.siadse.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InscripcionDTO {
    private String codigo;
    private UserDTO userDTO;
}
