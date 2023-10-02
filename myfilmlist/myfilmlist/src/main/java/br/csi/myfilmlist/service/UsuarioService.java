package br.csi.myfilmlist.service;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import br.csi.myfilmlist.model.filme.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.csi.myfilmlist.model.usuario.Permissao;
import br.csi.myfilmlist.model.usuario.Usuario;
import br.csi.myfilmlist.model.usuario.UsuarioDTO;
import br.csi.myfilmlist.repository.UsuarioRepository;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PermissaoService permissaoService;
    private final FilmeService filmeService;
    private final AssistirService assistirService;

    public UsuarioService(UsuarioRepository u, PermissaoService p, FilmeService filmeService, AssistirService assistirService){
        this.usuarioRepository = u;
        this.permissaoService = p;
        this.filmeService = filmeService;
        this.assistirService = assistirService;
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

    public Usuario atualizar(Usuario u){
        Usuario usuario = this.usuarioRepository.findById(u.getIdusuario()).get();
        usuario.setEmail(u.getEmail());
        usuario.setNomeusuario(u.getNomeusuario());
        usuario.setSenha(new BCryptPasswordEncoder().encode(u.getSenha()));
        usuarioRepository.save(usuario);
        return usuario;
    }

    public void excluir(Long id){
        Usuario usuario = this.usuarioRepository.getReferenceById(id);
        usuario.setAtivo(false);
        usuarioRepository.save(usuario);
    }

    public UsuarioDTO findUsuario(Long id){
        Usuario usuario = this.usuarioRepository.getReferenceById(id);
        return new UsuarioDTO(usuario.getNomeusuario(), usuario.getEmail(), usuario.getIdusuario(), usuario.isAtivo(), usuario.getPermissao(),new HashSet<>());
    }

    public void assistirFilme(Long idFilme){
        Filme filme = filmeService.findFilme(idFilme);
        UserDetails g = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Usuario usuario = usuarioRepository.findByEmail(g.getUsername()).get();
        Assistir assistirFilme = new Assistir();
        assistirFilme.setId(new AssistirKey(usuario.getIdusuario(), filme.getIdfilme()));
        assistirFilme.setFilme(filme);
        assistirFilme.setUsuario(usuario);
        assistirFilme.setStatusAssistir(StatusAssistir.PARA_ASSISTIR);
        this.assistirService.salvar(assistirFilme);
    }

    public void marcarFilmeAssistido(Long idFilme){
        Filme filme = filmeService.findFilme(idFilme);
        Usuario usuario = usuarioRepository.getReferenceById(2l);
        Assistir assistirFilme = new Assistir();
        assistirFilme.setId(new AssistirKey(usuario.getIdusuario(), filme.getIdfilme()));
        assistirFilme.setFilme(filme);
        assistirFilme.setUsuario(usuario);
        assistirFilme.setStatusAssistir(StatusAssistir.ASSISTIDO);
        this.assistirService.salvar(assistirFilme);
    }

    public List<FilmeDTO> findAllByUsuario(){
        List<Assistir> ass = assistirService.findAllByUsuario(3l);
        List<FilmeDTO> filmes = new LinkedList<>();
        ass.stream().forEach(a -> {
            FilmeDTO f = new FilmeDTO();
            f.setNomefilme(a.getFilme().getNomefilme());
            f.setDescricao(a.getFilme().getDescricao());
            f.setDuracao(a.getFilme().getDuracao());
            f.setGenero(a.getFilme().getGenero());
            filmes.add(f);
        });
        return filmes;
    }
}
