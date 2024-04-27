package BackendSiadseUfps.siadse.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comentario")
public class Comentario {
    /**
     * id del comentario
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    /**
     * comentario realizado por el usuario al contenido multimedia
     */
    @NotNull(message = "comment cannot be null")
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "id_contenidos_multimedia", nullable = false)
    private ContenidoMultimedia contenidoMultimedia;

    private Date fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private  OurUsers user;
}
