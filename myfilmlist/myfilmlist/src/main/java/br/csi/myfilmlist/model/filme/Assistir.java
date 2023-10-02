package br.csi.myfilmlist.model.filme;

import br.csi.myfilmlist.model.usuario.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class Assistir {
    @EmbeddedId
    private AssistirKey id;

    @ManyToOne
    @MapsId("idusuario")
    @JoinColumn(name = "idusuario")
    private Usuario usuario;

    @ManyToOne
    @MapsId("idfilme")
    @JoinColumn(name = "idfilme")
    private Filme filme;

    @Enumerated(EnumType.STRING)
    @Column(name = "situacao")
    private StatusAssistir statusAssistir;
}
