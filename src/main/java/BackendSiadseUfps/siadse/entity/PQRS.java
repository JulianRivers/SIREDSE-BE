package com.ufps.pqrsbe.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "pqrs")
public class PQRS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Titulo del PQRS no puede ser nulo")
    private String titulo;

    @NotNull(message = "Descripcion del PQRS no puede ser nulo")
    private String descripcion;

    private Date fechaRadicado;

    @ManyToOne
    @JoinColumn(name = "id_estados", nullable = false)
    private EstadosPQRS estadoRadicado;

    @NotNull(message = "Correo del radicado no puede ser nulo")
    private String correo;

    @ManyToOne
    @JoinColumn(name = "id_tipos_pqrs", nullable = false)
    private TiposPQRS tipoPqrs;

    @NotNull(message = "Anonimo no puede quedar sin eleccion")
    private Boolean anonimo;

    private String nombre;

    private String apellido;

    private String cedula;

    private String semillero;

    private String codigoRadicado;

}
