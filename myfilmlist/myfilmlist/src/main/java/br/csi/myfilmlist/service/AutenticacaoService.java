package br.csi.myfilmlist.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.csi.myfilmlist.model.usuario.Usuario;
import br.csi.myfilmlist.repository.UsuarioRepository;

@Service
public class AutenticacaoService implements UserDetailsService {
    private final UsuarioRepository repository;
    public AutenticacaoService(UsuarioRepository repository){
        this.repository = repository;
    }
    //Método destiando a criação de um UserDetail que será inserido no contexto o Spring
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario usuario = this.repository.findByEmail(login).orElseThrow(()-> new UsernameNotFoundException("usuario nao encontrado"));
        UserDetails user = User.withUsername(usuario.getEmail()).password(usuario.getSenha())
                    .authorities(usuario.getPermissao().getNomepermissao()).build();
        return user;
    }
}
