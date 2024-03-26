package com.example.demo.Data.DTO;

import com.example.demo.Data.Usuario;

public class UsuarioMapper {

        public UsuarioDto UsuarioDtoToUsuarioEntity( UsuarioDto usuarioDto){
            Usuario usuario = new Usuario();
            usuario.setNombre(usuarioDto.nombre);
            usuario.setApellido(usuarioDto.apellido);
            usuario.setEmail(usuarioDto.email);
            usuario.setId(usuarioDto.id);
            usuario.setSugerencias(usuarioDto.sugerencias);
        }

        public Usuario UsuarioSaveDtoToUsuarioEntity(UsuarioToSaveDto usuarioDto){
            Usuario usuario = Usuario.builder().
                                        nombre(usuarioDto.nombre).
                                        apellido(usuarioDto.apellido).
                                        email(usuarioDto.email).
                                        username(usuarioDto.username)
                                        .build();
            return usuario;
        }
}
