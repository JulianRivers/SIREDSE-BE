package BackendSiadseUfps.siadse.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contenido_multimedia")
public class ContenidoMultimedia {
    /**
     * id del contenido multimedia
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * nombre como se guardara el archivo multimedia
     */
    @NotNull(message = "titulo cannot be null")
    private String titulo;
    /**
     * fecha en la que se subio el archivo multimedia
     */
    private Date fechaSubida;

    /**
     * url donde se encuentra el documento
     */
    @Column(nullable = true)
    private String url;

    /**
     * Key del archivo en el s3
     */
    @Column(nullable = false)
    private String keyFile;

    /**
     * Extensión del archivo subido
     */
    @Column(nullable = false)
    private String formato;

    @ManyToOne
    @JoinColumn(name = "id_album", nullable = false)
    private Album album;
}
