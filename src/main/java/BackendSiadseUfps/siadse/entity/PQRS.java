package BackendSiadseUfps.siadse.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;


import java.util.Date;

/**
 * Entidad que representa una solicitud PQRS en la base de datos.
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
 * - `@ManyToOne`: Indica una relación muchos a uno con otra entidad.
 * - `@JoinColumn`: Especifica la columna que se usará para la unión en una relación muchos a uno.
 * - `@Size`: Restricción que define el tamaño máximo de un campo.
 * - `@NotNull`: Restricción que indica que un campo no puede ser nulo.
 */
@Data
@Entity
@Table(name = "pqrs")
public class PQRS {

    /**
     * El ID de la solicitud PQRS.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * El título de la solicitud PQRS.
     * Debe tener como máximo 30 caracteres.
     * No puede ser nulo.
     */
    @Size(max = 30, message = "El título debe tener como máximo 30 caracteres")
    @NotNull(message = "El título del PQRS no puede ser nulo")
    private String titulo;

    /**
     * La descripción de la solicitud PQRS.
     * Debe tener como máximo 100 caracteres.
     * No puede ser nulo.
     */
    @Size(max = 100, message = "La descripción debe tener como máximo 100 caracteres")
    @NotNull(message = "La descripción del PQRS no puede ser nula")
    private String descripcion;

    /**
     * La fecha en que se radicó la solicitud PQRS.
     */
    private Date fechaRadicado;

    /**
     * El estado de la radicación de la solicitud PQRS.
     * Relación muchos a uno con la entidad EstadosPQRS.
     */
    @ManyToOne
    @JoinColumn(name = "id_estados", nullable = false)
    private EstadosPQRS estadoRadicado;

    /**
     * El correo electrónico asociado a la solicitud PQRS.
     * Debe tener como máximo 30 caracteres.
     * No puede ser nulo.
     */
    @Size(max = 30, message = "El correo debe tener como máximo 30 caracteres")
    @NotNull(message = "El correo del radicado no puede ser nulo")
    private String correo;

    /**
     * El tipo de solicitud PQRS.
     * Relación muchos a uno con la entidad TiposPQRS.
     */
    @ManyToOne
    @JoinColumn(name = "id_tipos_pqrs", nullable = false)
    private TiposPQRS tipoPqrs;

    /**
     * Indicador de si la solicitud PQRS es anónima.
     * No puede ser nulo.
     */
    @NotNull(message = "Anonimo no puede quedar sin elección")
    private Boolean anonimo;

    /**
     * El nombre de la persona que realiza la solicitud PQRS.
     * Debe tener como máximo 30 caracteres.
     */
    @Size(max = 30, message = "El nombre debe tener como máximo 30 caracteres")
    private String nombre;

    /**
     * El apellido de la persona que realiza la solicitud PQRS.
     * Debe tener como máximo 30 caracteres.
     */
    @Size(max = 30, message = "El apellido debe tener como máximo 30 caracteres")
    private String apellido;

    /**
     * La cédula de la persona que realiza la solicitud PQRS.
     * Debe tener como máximo 30 caracteres.
     */
    @Size(max = 30, message = "La cédula debe tener como máximo 30 caracteres")
    private String cedula;

    /**
     * El semillero asociado a la solicitud PQRS.
     * Debe tener como máximo 50 caracteres.
     */
    @Size(max = 50, message = "El semillero debe tener como máximo 50 caracteres")
    private String semillero;

    /**
     * El código de radicación de la solicitud PQRS.
     * Debe tener como máximo 100 caracteres.
     */
    @Size(max = 100, message = "El código de radicación debe tener como máximo 100 caracteres")
    private String codigoRadicado;

    // Getters y setters generados automáticamente por Lombok

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaRadicado() {
        return fechaRadicado;
    }

    public void setFechaRadicado(Date fechaRadicado) {
        this.fechaRadicado = fechaRadicado;
    }

    public EstadosPQRS getEstadoRadicado() {
        return estadoRadicado;
    }

    public void setEstadoRadicado(EstadosPQRS estadoRadicado) {
        this.estadoRadicado = estadoRadicado;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public TiposPQRS getTipoPqrs() {
        return tipoPqrs;
    }

    public void setTipoPqrs(TiposPQRS tipoPqrs) {
        this.tipoPqrs = tipoPqrs;
    }

    public Boolean getAnonimo() {
        return anonimo;
    }

    public void setAnonimo(Boolean anonimo) {
        this.anonimo = anonimo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getSemillero() {
        return semillero;
    }

    public void setSemillero(String semillero) {
        this.semillero = semillero;
    }

    public String getCodigoRadicado() {
        return codigoRadicado;
    }

    public void setCodigoRadicado(String codigoRadicado) {
        this.codigoRadicado = codigoRadicado;
    }
}
