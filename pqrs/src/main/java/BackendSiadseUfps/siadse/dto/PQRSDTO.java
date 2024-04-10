package BackendSiadseUfps.siadse.dto;

import BackendSiadseUfps.siadse.entity.EstadosPQRS;
import BackendSiadseUfps.siadse.entity.Semillero;
import BackendSiadseUfps.siadse.entity.TiposPQRS;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PQRSDTO {

    private Integer id;
    private String titulo;
    private String descripcion;
    private Date fechaRadicado;
    private EstadosPQRS estadoRadicado;
    private String correo;
    private TiposPQRS tiposPqrs;
    private Boolean anonimo;
    private String nombre;
    private String apellido;
    private String cedula;
    private Semillero semillero;
    private String codigoRadicado;
}
