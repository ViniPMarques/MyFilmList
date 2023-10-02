package br.csi.myfilmlist.model.filme;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
@Entity
@Table
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idfilme")
    private Long idfilme;

    @NotBlank(message = "nome filme inválido")
    @Column
    private String nomefilme;

    @NotBlank(message = "descrição inválida")
    @Column
    private String descricao;

    @Positive
    @Column
    private Integer duracao;

    @NotBlank(message = "genero inválido")
    @Column
    private String genero;

    @Column
    private boolean ativo;
    
    @OneToMany(mappedBy = "filme")
    @JsonIgnore
    Set<Assistir> usuarios;
}
