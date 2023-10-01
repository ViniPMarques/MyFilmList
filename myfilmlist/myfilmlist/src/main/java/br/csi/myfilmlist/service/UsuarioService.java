package br.csi.myfilmlist.service;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.csi.myfilmlist.model.usuario.Permissao;
import br.csi.myfilmlist.model.usuario.Usuario;
import br.csi.myfilmlist.repository.UsuarioRepository;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PermissaoService permissaoService;

    public UsuarioService(UsuarioRepository u, PermissaoService p){
        this.usuarioRepository = u;
        this.permissaoService = p;
    }

    public Usuario salvar(Usuario u) throws Exception{
        Optional<Usuario> usuario = this.usuarioRepository.findByEmail(u.getEmail());

        if(usuario.isPresent())
            throw new Exception("usuario já existe");
        
        u.setSenha(new BCryptPasswordEncoder().encode(u.getSenha()));

        Permissao p = this.permissaoService.findById(2l).get();
        p.setIdpermissao(2l);
        u.setPermissao(p);
        return this.usuarioRepository.save(u);
    }
}
