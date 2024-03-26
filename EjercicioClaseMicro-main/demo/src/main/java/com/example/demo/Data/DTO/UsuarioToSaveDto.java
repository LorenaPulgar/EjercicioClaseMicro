package com.example.demo.Data.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name="usuarios")
public class UsuarioToSaveDto  {
    
    private Long id;
    private String username;
    private String email;
    private String nombre;
    private String apellido;
    private  Integer edad;

    
    
}

