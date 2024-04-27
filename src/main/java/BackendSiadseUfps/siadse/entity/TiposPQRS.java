package BackendSiadseUfps.siadse.entity;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Tipos_PQRS")
public class TiposPQRS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String tipo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
