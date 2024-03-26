package com.example.demo.Data.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.Data.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{

}