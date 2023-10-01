package br.csi.myfilmlist.service;

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
        return this.filmeRepository.save(filme);
    }
}
