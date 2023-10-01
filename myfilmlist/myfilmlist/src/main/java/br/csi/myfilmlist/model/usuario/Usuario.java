package br.csi.myfilmlist.model.usuario;

import java.util.Set;

import br.csi.myfilmlist.model.filme.Assistir;
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
import lombok.Data;

@Data
@Entity
@Table
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idusuario;

    @Column
    private String nomeusuario;
    
    @Column
    private String email;

    @Column
    private String senha;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idpermissao", referencedColumnName = "idpermissao")
    private Permissao permissao;

    @OneToMany(mappedBy = "usuario")
    Set<Assistir> filmes;
}
