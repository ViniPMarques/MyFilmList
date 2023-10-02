package br.csi.myfilmlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.csi.myfilmlist.model.usuario.Permissao;

@Repository
public interface PermissaoRepository extends JpaRepository<Permissao,Long> {
    
}
