package BackendSiadseUfps.siadse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class LoginDTO {
    private String email;
    private String password;

    // Implementación de getUsername y getPassword
    public String getUsername() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }
}
