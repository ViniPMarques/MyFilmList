package br.csi.myfilmlist.controller;

import java.util.List;

import br.csi.myfilmlist.model.filme.Filme;
import br.csi.myfilmlist.model.filme.FilmeDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.csi.myfilmlist.model.filme.Assistir;
import br.csi.myfilmlist.model.usuario.Usuario;
import br.csi.myfilmlist.model.usuario.UsuarioDTO;
import br.csi.myfilmlist.service.UsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }
    @PostMapping
    public ResponseEntity<Usuario> cadastrar(@Valid @RequestBody Usuario usuario) throws Exception{
        return new ResponseEntity<>(this.usuarioService.salvar(usuario),new HttpHeaders(), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Usuario> atualizar(@Valid @RequestBody Usuario usuario) throws Exception{
        return new ResponseEntity<>(this.usuarioService.atualizar(usuario),new HttpHeaders(), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        this.usuarioService.excluir(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public UsuarioDTO findUsuario(@PathVariable Long id){
        return this.usuarioService.findUsuario(id);
    }
    
    @PutMapping("/assistir-filme/{idFilme}")
    public ResponseEntity<String> assistirFilme(@PathVariable Long idFilme){
        this.usuarioService.assistirFilme(idFilme);
        return new ResponseEntity<String>("filme marcado para assistir",new HttpHeaders(),HttpStatus.CREATED);
    }
    @PutMapping("/marcar-filme-assistido/{idFilme}")
    public ResponseEntity<String> marcarFilmeAssistido(@PathVariable Long idFilme){
        this.usuarioService.marcarFilmeAssistido(idFilme);
        return new ResponseEntity<String>("filme assistido com sucesso",new HttpHeaders(),HttpStatus.CREATED);
    }

    @GetMapping("/get-filmes")
    public ResponseEntity<List<FilmeDTO>> getFilmes(){
        return new ResponseEntity<>(usuarioService.findAllByUsuario(),new HttpHeaders(), HttpStatus.OK);
    }
}