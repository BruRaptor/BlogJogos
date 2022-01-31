package com.noticias.jogos.BlogJogos.repository;

import java.util.Optional;

import com.noticias.jogos.BlogJogos.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    public Optional<Usuario> findByUsuario(String usuario);
    
}