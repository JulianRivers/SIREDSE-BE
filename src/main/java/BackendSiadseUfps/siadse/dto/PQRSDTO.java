package BackendSiadseUfps.siadse.dto;


import BackendSiadseUfps.siadse.entity.EstadosPQRS;
import BackendSiadseUfps.siadse.entity.TiposPQRS;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Data Transfer Object (DTO) para la entidad PQRS.
 *
 * Esta clase se utiliza para transferir datos de una solicitud PQRS entre las capas de la aplicación.
 *
 * Las anotaciones de Lombok utilizadas en esta clase son:
 *
 * - `@Data`: Genera automáticamente getters, setters, métodos toString, equals, hashCode, y un constructor sin argumentos.
 * - `@Builder`: Proporciona un patrón de diseño Builder para construir objetos de la clase.
 * - `@AllArgsConstructor`: Genera automáticamente un constructor con un parámetro para cada campo de la clase.
 * - `@NoArgsConstructor`: Genera automáticamente un constructor sin argumentos.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PQRSDTO {

    /**
     * El ID de la solicitud PQRS.
     */
    private Integer id;

    /**
     * El título de la solicitud PQRS.
     */
    private String titulo;

    /**
     * La descripción de la solicitud PQRS.
     */
    private String descripcion;

    /**
     * La fecha en que se radicó la solicitud PQRS.
     */
    private Date fechaRadicado;

    /**
     * El estado de la radicación de la solicitud PQRS.
     */
    private EstadosPQRS estadoRadicado;

    /**
     * El correo electrónico asociado a la solicitud PQRS.
     */
    private String correo;

    /**
     * El tipo de solicitud PQRS.
     */
    private TiposPQRS tipoPqrs;

    /**
     * Indicador de si la solicitud PQRS es anónima.
     */
    private Boolean anonimo;

    /**
     * El nombre de la persona que realiza la solicitud PQRS.
     */
    private String nombre;

    /**
     * El apellido de la persona que realiza la solicitud PQRS.
     */
    private String apellido;

    /**
     * La cédula de la persona que realiza la solicitud PQRS.
     */
    private String cedula;

    /**
     * El semillero asociado a la solicitud PQRS.
     */
    private String semillero;

    /**
     * El código de radicación de la solicitud PQRS.
     */
    private String codigoRadicado;

    // Getters y Setters

    /**
     * Obtiene el ID de la solicitud PQRS.
     *
     * @return el ID de la solicitud PQRS.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Establece el ID de la solicitud PQRS.
     *
     * @param id el nuevo ID de la solicitud PQRS.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtiene el título de la solicitud PQRS.
     *
     * @return el título de la solicitud PQRS.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título de la solicitud PQRS.
     *
     * @param titulo el nuevo título de la solicitud PQRS.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene la descripción de la solicitud PQRS.
     *
     * @return la descripción de la solicitud PQRS.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción de la solicitud PQRS.
     *
     * @param descripcion la nueva descripción de la solicitud PQRS.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la fecha de radicación de la solicitud PQRS.
     *
     * @return la fecha de radicación de la solicitud PQRS.
     */
    public Date getFechaRadicado() {
        return fechaRadicado;
    }

    /**
     * Establece la fecha de radicación de la solicitud PQRS.
     *
     * @param fechaRadicado la nueva fecha de radicación de la solicitud PQRS.
     */
    public void setFechaRadicado(Date fechaRadicado) {
        this.fechaRadicado = fechaRadicado;
    }

    /**
     * Obtiene el estado de radicación de la solicitud PQRS.
     *
     * @return el estado de radicación de la solicitud PQRS.
     */
    public EstadosPQRS getEstadoRadicado() {
        return estadoRadicado;
    }

    /**
     * Establece el estado de radicación de la solicitud PQRS.
     *
     * @param estadoRadicado el nuevo estado de radicación de la solicitud PQRS.
     */
    public void setEstadoRadicado(EstadosPQRS estadoRadicado) {
        this.estadoRadicado = estadoRadicado;
    }

    /**
     * Obtiene el correo electrónico asociado a la solicitud PQRS.
     *
     * @return el correo electrónico asociado a la solicitud PQRS.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico asociado a la solicitud PQRS.
     *
     * @param correo el nuevo correo electrónico asociado a la solicitud PQRS.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene el tipo de solicitud PQRS.
     *
     * @return el tipo de solicitud PQRS.
     */
    public TiposPQRS getTipoPqrs() {
        return tipoPqrs;
    }

    /**
     * Establece el tipo de solicitud PQRS.
     *
     * @param tipoPqrs el nuevo tipo de solicitud PQRS.
     */
    public void setTipoPqrs(TiposPQRS tipoPqrs) {
        this.tipoPqrs = tipoPqrs;
    }

    /**
     * Obtiene el indicador de si la solicitud PQRS es anónima.
     *
     * @return el indicador de si la solicitud PQRS es anónima.
     */
    public Boolean getAnonimo() {
        return anonimo;
    }

    /**
     * Establece el indicador de si la solicitud PQRS es anónima.
     *
     * @param anonimo el nuevo indicador de si la solicitud PQRS es anónima.
     */
    public void setAnonimo(Boolean anonimo) {
        this.anonimo = anonimo;
    }

    /**
     * Obtiene el nombre de la persona que realiza la solicitud PQRS.
     *
     * @return el nombre de la persona que realiza la solicitud PQRS.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la persona que realiza la solicitud PQRS.
     *
     * @param nombre el nuevo nombre de la persona que realiza la solicitud PQRS.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido de la persona que realiza la solicitud PQRS.
     *
     * @return el apellido de la persona que realiza la solicitud PQRS.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido de la persona que realiza la solicitud PQRS.
     *
     * @param apellido el nuevo apellido de la persona que realiza la solicitud PQRS.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene la cédula de la persona que realiza la solicitud PQRS.
     *
     * @return la cédula de la persona que realiza la solicitud PQRS.
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Establece la cédula de la persona que realiza la solicitud PQRS.
     *
     * @param cedula la nueva cédula de la persona que realiza la solicitud PQRS.
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * Obtiene el semillero asociado a la solicitud PQRS.
     *
     * @return el semillero asociado a la solicitud PQRS.
     */
    public String getSemillero() {
        return semillero;
    }

    /**
     * Establece el semillero asociado a la solicitud PQRS.
     *
     * @param semillero el nuevo semillero asociado a la solicitud PQRS.
     */
    public void setSemillero(String semillero) {
        this.semillero = semillero;
    }

    /**
     * Obtiene el código de radicación de la solicitud PQRS.
     *
     * @return el código de radicación de la solicitud PQRS.
     */
    public String getCodigoRadicado() {
        return codigoRadicado;
    }

    /**
     * Establece el código de radicación de la solicitud PQRS.
     *
     * @param codigoRadicado el nuevo código de radicación de la solicitud PQRS.
     */
    public void setCodigoRadicado(String codigoRadicado) {
        this.codigoRadicado = codigoRadicado;
    }
}
