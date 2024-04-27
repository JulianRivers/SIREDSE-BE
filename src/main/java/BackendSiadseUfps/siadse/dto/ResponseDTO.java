package BackendSiadseUfps.siadse.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.access.annotation.Secured;

@Getter
@Setter
public class ResponseDTO {
    private String message;
}
