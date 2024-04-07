package BackendSiadseUfps.siadse.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "semillero")
public class Semillero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer id_grupo;
    private Integer id_lider;
    @Column(name = "linea_investigacion")
    private Integer lineaInvestigacion;
    private String descripcion;
    private String Logo;
    
    
}