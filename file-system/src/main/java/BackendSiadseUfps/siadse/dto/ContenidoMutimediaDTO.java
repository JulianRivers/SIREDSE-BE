package BackendSiadseUfps.siadse.dto;
import lombok.*;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContenidoMutimediaDTO {
    private Integer id;
    /**
     * nombre como se guardara el archivo multimedia
     */

    private String titulo;
    /**
     * fecha en la que se subio el archivo multimedia
     */
    private Date fechaSubida;

    /**
     * url donde se encuentra el documento
     */

    private String url;

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

    public Date getFechaSubida() {
        return fechaSubida;
    }

    public void setFechaSubida(Date fechaSubida) {
        this.fechaSubida = fechaSubida;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKeyFile() {
        return keyFile;
    }

    public void setKeyFile(String keyFile) {
        this.keyFile = keyFile;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    /**
     * Key del archivo en el s3
     */

    private String keyFile;

    /**
     * Extensión del archivo subido
     */

    private String formato;


    private Integer albumId;
}
