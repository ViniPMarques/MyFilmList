package br.csi.myfilmlist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.csi.myfilmlist.model.filme.Assistir;
import br.csi.myfilmlist.model.filme.AssistirKey;

@Repository
public interface AssistirRepository extends JpaRepository<Assistir,AssistirKey>{
    @Query("SELECT a FROM Assistir a WHERE a.usuario.idusuario = ?1")
    public List<Assistir> findAllByUsuario(Long id);
}
