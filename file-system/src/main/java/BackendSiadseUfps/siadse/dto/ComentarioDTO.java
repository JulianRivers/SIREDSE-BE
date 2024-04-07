package BackendSiadseUfps.siadse.dto;

import BackendSiadseUfps.siadse.entity.ContenidoMultimedia;
import BackendSiadseUfps.siadse.entity.OurUsers;
import lombok.*;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ComentarioDTO {
    private Integer id;

    private String comentario;

    private Integer contenidoMultimediaId;

    private Date fechaCreacion;

    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Integer getContenidoMultimediaId() {
        return contenidoMultimediaId;
    }

    public void setContenidoMultimediaId(Integer contenidoMultimediaId) {
        this.contenidoMultimediaId = contenidoMultimediaId;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
