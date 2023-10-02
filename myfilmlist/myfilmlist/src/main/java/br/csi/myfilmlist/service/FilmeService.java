package br.csi.myfilmlist.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.csi.myfilmlist.model.filme.Filme;
import br.csi.myfilmlist.repository.FilmeRepository;

@Service
public class FilmeService {
    private final FilmeRepository filmeRepository;
    public FilmeService(FilmeRepository filmeRepository){
        this.filmeRepository = filmeRepository;
    }
    public Filme salvar(Filme filme){
        filme.setAtivo(true);
        return this.filmeRepository.save(filme);
    }
    public Filme atualizar(Filme f){
        Filme filme = this.filmeRepository.findById(f.getIdfilme()).get();
        filme.setDescricao(f.getDescricao());
        filme.setDuracao(f.getDuracao());
        filme.setGenero(f.getGenero());
        filme.setNomefilme(f.getNomefilme());
        return filme;
    }

    public void excluir(Long id){
        Filme filme = this.filmeRepository.findById(id).get();
        filme.setAtivo(false);
        filmeRepository.save(filme);
    }

    public Filme findFilme(Long id){
        Filme filme = this.filmeRepository.findById(id).get();
        return filme;
    }

    public List<Filme> findAllFilmes(){
        return filmeRepository.findAll();
    }
}
