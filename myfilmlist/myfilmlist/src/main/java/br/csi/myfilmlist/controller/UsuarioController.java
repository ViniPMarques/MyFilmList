package br.csi.myfilmlist.controller;

import br.csi.myfilmlist.model.usuario.UsuarioDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.csi.myfilmlist.model.usuario.Usuario;
import br.csi.myfilmlist.service.UsuarioService;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping("/print-json")
    public void printJSon(@RequestBody String json){
        System.out.println(json);
    }

    @GetMapping("/{idusuario}")
    public Usuario usuario(@PathVariable Long idusuario) {return this.usuarioService.findbyId(idusuario);}

    @PostMapping
    @Transactional
    public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario) throws Exception{
        return new ResponseEntity<>(this.usuarioService.salvar(usuario),new HttpHeaders(), HttpStatus.CREATED);
    }

//    @PostMapping
//    @Transactional
//    public ResponseEntity salvar(@RequestBody @Valid Usuario usuario, UriComponentsBuilder uriBuilder) throws Exception {
//
//        this.usuarioService.salvar(usuario);
//        URI uri = uriBuilder.path("/usuario/{idusuario}").buildAndExpand(usuario.getIdusuario()).toUri();
//        return ResponseEntity.created(uri).body(usuario);
//    }
    @GetMapping
    public ResponseEntity<List<Usuario>> listar(){return ResponseEntity.ok(this.usuarioService.listar());}

    //Atualizar, mas não é bom deixar no controller (ARRUMAR POSTERIORMENTE)
    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody Usuario usuario){
        this.usuarioService.atualizar(usuario);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{idusuario}")
    public ResponseEntity deletar(@PathVariable Long idusuario){
        this.usuarioService.excluir(idusuario);
        return ResponseEntity.noContent().build();
    }

    //Listagem de usuarios por filme (UsuarioService)
//    @GetMapping("/filme/{idfilme}")
//    public List<UsuarioDTO> listarUsuarios(@PathVariable int idfilme){return this.usuarioService.findUsuariosPorFilme(idfilme);}
}
