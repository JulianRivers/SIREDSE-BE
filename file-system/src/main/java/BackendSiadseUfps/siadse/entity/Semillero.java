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
@Table(name = "semillero")
public class Semillero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "titulo cannot be null")
    private String nombre;

    private String descripcion;

    private Date fechaCreacion;

    private Date fechaActualizacion;

}
