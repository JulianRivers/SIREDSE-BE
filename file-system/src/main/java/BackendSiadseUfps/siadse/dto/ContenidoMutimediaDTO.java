package BackendSiadseUfps.siadse.dto;
import lombok.*;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContenidoMutimediaDTO {
    private Integer id;
    /**
     * nombre como se guardara el archivo multimedia
     */

    private String titulo;
    /**
     * fecha en la que se subio el archivo multimedia
     */
    private Date fechaSubida;

    /**
     * url donde se encuentra el documento
     */

    private String url;

    /**
     * Key del archivo en el s3
     */

    private String keyFile;

    /**
     * Extensión del archivo subido
     */

    private String formato;


    private Integer albumId;
}
