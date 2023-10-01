package br.csi.myfilmlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.csi.myfilmlist.model.filme.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme,Long>{
    
}
