package com.example.demo.Data;

import java.time.LocalDate;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Partidas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder


public class Partidas {
    @ManyToMany(mappedBy="partidas")
    List<Usuario> usuarios;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String creador;
    @Column
    private String deporte;
    @Column
    private String ciudad;
    @Column
    private String provincia;
    @Column
    private LocalDate fecha;
    @Column
    private LocalDate hora_comienzo;
    @Column
    private LocalDate hora_final;
    @Column
    private Integer participantes;
    @Column
    private Integer suplentes;
    @Column
    private String comentarios;


}
