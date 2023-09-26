package br.csi.myfilmlist.model.usuario;

public class Permissao {

    private Long idpermissao;
    private String nomepermissao;

    public Long getIdpermissao() {
        return idpermissao;
    }

    public void setIdpermissao(Long idpermissao) {
        this.idpermissao = idpermissao;
    }

    public String getNomepermissao() {
        return nomepermissao;
    }

    public void setNomepermissao(String nomepermissao) {
        this.nomepermissao = nomepermissao;
    }

    public Permissao(Long idpermissao, String nomepermissao) {
        this.idpermissao = idpermissao;
        this.nomepermissao = nomepermissao;
    }
}
