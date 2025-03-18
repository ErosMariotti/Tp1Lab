package com.eros.tp1_1lab;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "noticia")
public class Noticia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 128, nullable = false)
    private String titulo;

    @Column(length = 1024)
    private String resumen;

    @Column(length = 128)
    private String imagen;

    @Column(length = 20480)
    private String contenidoHtml;

    @Column(length = 1)
    private char publicada;

    private LocalDate fechaPublicacion;

    @ManyToOne
    @JoinColumn(name = "id_empresa", nullable = false)
    private Empresa empresa;
}