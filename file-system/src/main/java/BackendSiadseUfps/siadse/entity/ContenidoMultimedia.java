package BackendSiadseUfps.siadse.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contenido_multimedia")
public class ContenidoMultimedia {
    /**
     * id del contenido multimedia
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(nullable = true)
    private String url;

    /**
     * Key del archivo en el s3
     */
    @Column(nullable = false)
    private String keyFile;

    /**
     * Extensión del archivo subido
     */
    private String formato;

    @ManyToOne
    @JoinColumn(name = "id_album", nullable = false)
    private Album album;

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

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
