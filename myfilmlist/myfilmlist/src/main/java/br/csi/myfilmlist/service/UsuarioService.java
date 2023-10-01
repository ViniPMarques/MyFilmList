package br.csi.myfilmlist.service;

import java.util.Optional;

import br.csi.myfilmlist.model.usuario.UsuarioDTO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.csi.myfilmlist.model.usuario.Permissao;
import br.csi.myfilmlist.model.usuario.Usuario;
import br.csi.myfilmlist.repository.UsuarioRepository;
import java.util.List;


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
    public List<Usuario> listar(){return this.usuarioRepository.findAll();}

    public void atualizar(Usuario usuario){
        Usuario u = this.usuarioRepository.getReferenceById(usuario.getIdusuario());
        u.setNomeusuario(usuario.getNomeusuario());
        u.setEmail(usuario.getEmail());
        u.setSenha(usuario.getSenha());
        u.setPermissao(usuario.getPermissao());
    }

    public void excluir(Long idusuario){this.usuarioRepository.deleteById(idusuario);}
//    public List<UsuarioDTO> findUsuariosPorFilme(int idfilme){return this.usuarioRepository.findUsuarios}
    public Usuario findbyId(Long idusuario) {return this.usuarioRepository.findById(idusuario).get();}
}
