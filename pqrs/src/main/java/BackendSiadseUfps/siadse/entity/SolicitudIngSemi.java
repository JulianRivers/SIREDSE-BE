package BackendSiadseUfps.siadse.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "solicitud_ingreso_semillero")
public class SolicitudIngSemi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
