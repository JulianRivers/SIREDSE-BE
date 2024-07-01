package BackendSiadseUfps.siadse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentRequest {
	
	private String email;
    private String projectName;
    private String studentName;
    private String semilleroName;
    private String directorEmail;
    private String directorPhone;
    private String directorName;

}
