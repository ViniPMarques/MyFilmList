package br.csi.myfilmlist.model.filme;

public class Filme {

    private Long idfilme;
    private String nomefilme;
    private String descricao;
    private Integer duracao;
    private String genero;

    public Long getIdfilme() {
        return idfilme;
    }

    public void setIdfilme(Long idfilme) {
        this.idfilme = idfilme;
    }

    public String getNomefilme() {
        return nomefilme;
    }

    public void setNomefilme(String nomefilme) {
        this.nomefilme = nomefilme;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Filme(Long idfilme, String nomefilme, String descricao, Integer duracao, String genero) {
        this.idfilme = idfilme;
        this.nomefilme = nomefilme;
        this.descricao = descricao;
        this.duracao = duracao;
        this.genero = genero;
    }
}
