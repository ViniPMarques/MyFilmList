package br.csi.myfilmlist.model.usuario;

import java.util.Set;

import br.csi.myfilmlist.model.filme.Assistir;
import lombok.Builder;

@Builder
public record UsuarioDTO(
    String nome,
    String email,
    Long id,
    boolean ativo,
    Permissao permissao,
    Set<Assistir> filmes
){}
