package br.csi.myfilmlist.model.usuario;

public class Usuario {

    private Long idusuario;
    private String nomeusuario;
    private String email;
    private String senha;
    private Permissao permissao;

    public Long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    public String getNomeusuario() {
        return nomeusuario;
    }

    public void setNomeusuario(String nomeusuario) {
        this.nomeusuario = nomeusuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Permissao getPermissao() {
        return permissao;
    }

    public void setPermissao(Permissao permissao) {
        this.permissao = permissao;
    }

    public Usuario(Long idusuario, String nomeusuario, String email, String senha, Permissao permissao) {
        this.idusuario = idusuario;
        this.nomeusuario = nomeusuario;
        this.email = email;
        this.senha = senha;
        this.permissao = permissao;
    }
}
