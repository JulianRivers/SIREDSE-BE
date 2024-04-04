package BackendSiadseUfps.siadse.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "lineas_de_investigacion")
public class LineasDeInvestigacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
