package br.csi.myfilmlist.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.csi.myfilmlist.model.usuario.Permissao;
import br.csi.myfilmlist.repository.PermissaoRepository;

@Service
public class PermissaoService {
    private final PermissaoRepository permissaoRepository;
    public PermissaoService(PermissaoRepository p){
        this.permissaoRepository = p;
    }
    public Optional<Permissao> findById(Long id){
        return this.permissaoRepository.findById(id);
    }
}
