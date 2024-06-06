package BackendSiadseUfps.siadse.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * Entidad que representa un tipo de solicitud PQRS en la base de datos.
 *
 * Las anotaciones de Lombok utilizadas en esta clase son:
 *
 * - `@Data`: Genera automáticamente getters, setters, métodos toString, equals, hashCode, y un constructor sin argumentos.
 *
 * Las anotaciones de JPA utilizadas en esta clase son:
 *
 * - `@Entity`: Indica que esta clase es una entidad JPA.
 * - `@Table`: Especifica la tabla de la base de datos que se mapeará a esta entidad.
 * - `@Id`: Indica el campo que será la clave primaria de la entidad.
 * - `@GeneratedValue`: Especifica la estrategia de generación de valores para la clave primaria.
 * - `@Size`: Restricción que define el tamaño máximo de un campo.
 */
@Data
@Entity
@Table(name = "Tipos_PQRS")
public class TiposPQRS {

    /**
     * El ID del tipo de solicitud PQRS.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * La descripción del tipo de solicitud PQRS.
     * Debe tener como máximo 30 caracteres.
     */
    @Size(max = 30, message = "La descripción debe tener como máximo 30 caracteres")
    private String tipo;

    /**
     * Obtiene el ID del tipo de solicitud PQRS.
     *
     * @return El ID del tipo de solicitud PQRS.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Establece el ID del tipo de solicitud PQRS.
     *
     * @param id El ID del tipo de solicitud PQRS.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtiene la descripción del tipo de solicitud PQRS.
     *
     * @return La descripción del tipo de solicitud PQRS.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece la descripción del tipo de solicitud PQRS.
     *
     * @param tipo La descripción del tipo de solicitud PQRS.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
