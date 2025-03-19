package com.eros.tp1_1lab.Modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 128, nullable = false)
    private String denominacion;

    @Column(length = 50)
    private String telefono;

    @Column(length = 256)
    private String horarioAtencion;

    @Column(length = 1024)
    private String quienesSomos;

    private Double latitud;
    private Double longitud;

    @Column(length = 256)
    private String domicilio;

    @Column(length = 75)
    private String email;
}