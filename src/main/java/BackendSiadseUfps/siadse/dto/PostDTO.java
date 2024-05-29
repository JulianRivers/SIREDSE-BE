package BackendSiadseUfps.siadse.dto;

import java.util.Date;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PostDTO {
    private Long id;
    private String titulo;
    private String imagen;
    private Date fechaCreacion;
    private String tag;
    private String link;
}
