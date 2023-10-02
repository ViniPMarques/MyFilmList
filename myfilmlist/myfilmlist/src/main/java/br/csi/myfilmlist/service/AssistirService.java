package br.csi.myfilmlist.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.csi.myfilmlist.model.filme.Assistir;
import br.csi.myfilmlist.repository.AssistirRepository;

@Service
public class AssistirService {
    private final AssistirRepository assistirRepository;
    public AssistirService(AssistirRepository assistirRepository){
        this.assistirRepository = assistirRepository;
    }
    public Assistir salvar(Assistir a){
        return this.assistirRepository.save(a);
    }
    public List<Assistir> findAllByUsuario(Long idUsuario){
        return assistirRepository.findAllByUsuario(idUsuario);
    }
}
