package BackendSiadseUfps.siadse.dto;


import java.util.Date;

public class NormatividadDTO {

        private Integer id;
        private String titulo;
        private Date fechaSubida;
        private String url;
        private String keyFile;
        private String formato;
        private Integer semillero;


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

    public Integer getIdSemillero() {
        return semillero;
    }

    public void setIdSemillero(Integer idSemillero) {
        this.semillero = idSemillero;
    }

}
