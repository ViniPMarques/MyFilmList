package br.csi.myfilmlist.model.usuario;

import java.util.Set;

import br.csi.myfilmlist.model.filme.Assistir;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idusuario;

    @NotBlank(message = "nome inválido")
    @Column
    private String nomeusuario;
    
    @Email(message = "email inválido")
    @Column
    private String email;

    @NotBlank(message = "senha inválida")
    @Size(min = 4, message = "senha minimo 4 caracteres")
    @Column
    private String senha;

    @Column
    private boolean ativo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idpermissao", referencedColumnName = "idpermissao")
    private Permissao permissao;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    Set<Assistir> filmes;
}
