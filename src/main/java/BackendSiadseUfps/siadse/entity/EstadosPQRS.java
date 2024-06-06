package BackendSiadseUfps.siadse.entity;


import lombok.Data;

import javax.persistence.*;
/**
 * Clase que representa los estados de las PQRS.
 * Esta clase se mapea a la tabla "estados_pqrs" en la base de datos.
 */
@Data
@Entity
@Table(name = "estados_pqrs")
public class EstadosPQRS {

    /**
     * Identificador único del estado de las PQRS.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Nombre del estado de las PQRS.
     */
    private String estado;

    /**
     * Obtiene el identificador del estado de las PQRS.
     *
     * @return Identificador del estado de las PQRS.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Establece el identificador del estado de las PQRS.
     *
     * @param id Identificador del estado de las PQRS.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del estado de las PQRS.
     *
     * @return Nombre del estado de las PQRS.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el nombre del estado de las PQRS.
     *
     * @param estado Nombre del estado de las PQRS.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
