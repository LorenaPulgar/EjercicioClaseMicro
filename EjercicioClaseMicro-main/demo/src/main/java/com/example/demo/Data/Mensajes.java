package com.example.demo.Data;

import java.time.LocalDate;

import org.springframework.cglib.core.Local;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Mensajes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class Mensajes {
    @ManyToOne
    @JoinColumn(name="idusuarios")
    private Usuario usuarios;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String creador;
    private String destinatario;
    private LocalDate create_at;
    private String contenido;
}
