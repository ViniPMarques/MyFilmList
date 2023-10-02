package br.csi.myfilmlist.model.filme;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class AssistirKey implements Serializable {
    @Column
    Long idusuario;
    @Column
    Long idfilme;
}
