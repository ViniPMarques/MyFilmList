package br.csi.myfilmlist.model.usuario;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "permissao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Permissao {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpermissao;
    @Column
    private String nomepermissao;
}
