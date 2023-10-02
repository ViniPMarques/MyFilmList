package br.csi.myfilmlist.model.filme;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class FilmeDTO {
    private Long idfilme;

    private String nomefilme;

    private String descricao;


    private Integer duracao;

    private String genero;

    private boolean ativo;
}
