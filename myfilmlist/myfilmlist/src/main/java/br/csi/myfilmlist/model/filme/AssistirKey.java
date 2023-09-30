package br.csi.myfilmlist.model.filme;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class AssistirKey {
    @Column
    private Long idUsuario;
    @Column
    private Long idFilme;
}
