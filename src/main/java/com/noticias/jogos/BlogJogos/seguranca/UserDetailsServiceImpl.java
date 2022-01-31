package com.noticias.jogos.BlogJogos.seguranca;

import java.util.Optional;

import com.noticias.jogos.BlogJogos.model.Usuario;
import com.noticias.jogos.BlogJogos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    
    @Autowired
    private UsuarioRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Usuario> user = userRepository.findByUsuario(username);
        user.orElseThrow(() -> new UsernameNotFoundException(username + "not found."));

        return user.map(UserDetailsImpl::new).get();
    }
}
