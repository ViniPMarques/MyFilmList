package br.csi.myfilmlist.model.usuario;

import java.util.Set;

import br.csi.myfilmlist.model.filme.Assistir;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idusuario;

    @NotNull
    private String nomeusuario;

    @Email(message = "Email inválido")
    private String email;

    @NotNull
    private String senha;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idpermissao", referencedColumnName = "idpermissao")
    private Permissao permissao;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    Set<Assistir> filmes;
}
