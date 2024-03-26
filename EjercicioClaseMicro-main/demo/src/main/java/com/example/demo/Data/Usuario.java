package com.example.demo.Data;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class Usuario {

    @ManyToMany(mappedBy = "Partidas")
    @JoinTable(name="Usuarios_Partidas",
        joinColumns= @JoinColumn( name="idusuarios", 
        referencedColumnName="id"), inverseJoinColumns=@JoinColumn( 
        name="idpartidas", 
        referencedColumnName="id"))
    List<Partidas> partidas;

    @OneToMany(mappedBy = "Usuarios")
    List<Sugerencias> sugerencias;

    @OneToMany(mappedBy = "Usuarios")
    List<Mensajes> mensajes;


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String username;
    @Column 
    private String email;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private  Integer edad;
    @Column
    private String password;
    @Column
    private String rep_password;
    @Column
    private boolean enabled;
    @Column
    private String foto;
    @Column
    private String rol;
    @Column
    private LocalDate create_at;

}
