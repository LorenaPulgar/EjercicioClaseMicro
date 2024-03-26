package com.example.demo.repository;

import com.example.demo.Data.Usuario;
import com.example.demo.Data.repository.UsuarioRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @BeforeEach
    void setUp() {
        usuarioRepository.deleteAll();
    }

    private Usuario initTestUser() {
        Usuario usuario = Usuario.builder()
                .nombre("Jose Tomas")
                .apellido("Quintero Cuello")
                .edad(20)
                .password("1234")
                .build();
        return usuarioRepository.save(usuario);
    }

    private void initMockUsers() {
        Usuario usuario1 = Usuario.builder()
                .nombre("Jose")
                .apellido("Quintero Cuello")
                .edad(20)
                .password("1234")
                .build();
        Usuario usuario2 = Usuario.builder()
                .nombre("Lorena")
                .apellido("Pulgar")
                .edad(21)
                .password("12345")
                .build();
        usuarioRepository.save(usuario1);
        usuarioRepository.save(usuario2);
    }

    @Test
    public void givenAnUser_whenSave_thenUserWithId() {
        Usuario userSaved = initTestUser();
        Assertions.assertNotNull(userSaved);
    }

    @Test
    public void givenId_findById() {
        Usuario usuario = initTestUser();
        Usuario foundUsuario = usuarioRepository.getReferenceById(usuario.getId());
        Assertions.assertNotNull(foundUsuario);
    }

    @Test
    public void givenUsers_findAll() {
        initMockUsers();
        List<Usuario> usuarios = usuarioRepository.findAll();
        Assertions.assertEquals(2, usuarios.size());
    }

    @Test
    public void givenId_whenDeleteUser_thenUserNotFound() {
        Usuario usuario = initTestUser();
        usuarioRepository.deleteById(usuario.getId());
        Optional<Usuario> deletedUser = usuarioRepository.findById(usuario.getId());
        Assertions.assertFalse(deletedUser.isPresent());
    }

    @Test
    public void givenName_updateUserName() {
        String nuevoNombre = "Juan";
        Usuario usuario = initTestUser();
        usuario.setNombre(nuevoNombre);
        usuarioRepository.save(usuario);
        Assertions.assertEquals(nuevoNombre, usuario.getNombre());
    }
}