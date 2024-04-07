package BackendSiadseUfps.siadse.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "estados_solicitud")
public class EstadosSoli {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String estado;
}
