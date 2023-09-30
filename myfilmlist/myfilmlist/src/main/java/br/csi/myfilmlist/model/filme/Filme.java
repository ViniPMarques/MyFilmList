package br.csi.myfilmlist.model.filme;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idfilme;
    @Column
    private String nomefilme;
    @Column
    private String descricao;
    @Column
    private Integer duracao;
    @Column
    private String genero;
    @OneToMany(mappedBy = "filme")
    Set<Assistir> usuarios;
}
