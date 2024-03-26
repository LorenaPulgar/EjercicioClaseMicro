package com.example.demo.Data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Data.Mensajes;

@Repository
public interface MensajeRepository extends JpaRepository<Mensajes, Long> {
}
