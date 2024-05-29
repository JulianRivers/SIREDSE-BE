package BackendSiadseUfps.siadse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;


import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "capacitaciones")
public class Capacitaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;
    private String fechai;
    private String fechaf;
    private String modalidad;
    private String ubicacion;
    private String costo;
    private String responsable;
    private String cargo;
    private String correo;
    private String telefono;
    private String cupos;
    private String objetivos;
    private String descripcion;
    private String logo;
    private String contenido;


}

