package br.csi.myfilmlist.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.csi.myfilmlist.model.usuario.Usuario;
import br.csi.myfilmlist.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }
    @PostMapping
    public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario) throws Exception{
        return new ResponseEntity<>(this.usuarioService.salvar(usuario),new HttpHeaders(), HttpStatus.CREATED);
    }
}
