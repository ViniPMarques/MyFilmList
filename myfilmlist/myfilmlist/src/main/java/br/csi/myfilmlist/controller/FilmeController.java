package br.csi.myfilmlist.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.csi.myfilmlist.model.filme.Filme;
import br.csi.myfilmlist.service.FilmeService;

@RestController
@RequestMapping("/filme")
public class FilmeController {
    private final FilmeService filmeService;
    public FilmeController(FilmeService f){
        this.filmeService = f;
    }
    @PostMapping
    public ResponseEntity<Filme> cadastrar(@RequestBody Filme filme){
        Filme f = this.filmeService.salvar(filme);
        return new ResponseEntity<>(f,new HttpHeaders(),HttpStatus.CREATED);
    }
}
