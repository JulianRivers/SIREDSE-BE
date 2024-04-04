package BackendSiadseUfps.siadse.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "semillero")
public class Semillero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private  Integer id_grupo;
    private Integer id_lider;
    private Integer lineaInvestigacion;
    private String descripcion;
    private String Logo;
    
    
}