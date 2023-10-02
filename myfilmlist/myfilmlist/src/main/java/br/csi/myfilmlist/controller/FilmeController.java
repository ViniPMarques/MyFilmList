package br.csi.myfilmlist.controller;

import java.util.List;

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

import br.csi.myfilmlist.model.filme.Filme;
import br.csi.myfilmlist.service.FilmeService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/filme")
public class FilmeController {
    private final FilmeService filmeService;
    public FilmeController(FilmeService f){
        this.filmeService = f;
    }
    @PostMapping
    public ResponseEntity<Filme> cadastrar(@Valid @RequestBody Filme filme){
        Filme f = this.filmeService.salvar(filme);
        return new ResponseEntity<>(f,new HttpHeaders(),HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Filme> atualizar(@Valid @RequestBody Filme filme) throws Exception{
        return new ResponseEntity<>(this.filmeService.atualizar(filme),new HttpHeaders(), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        this.filmeService.excluir(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public Filme findFilme(@PathVariable Long id){
        return this.filmeService.findFilme(id);
    }
    @GetMapping
    public List<Filme> filmes(){
        return this.filmeService.findAllFilmes();
    }
}
