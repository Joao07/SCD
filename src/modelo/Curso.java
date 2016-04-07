package modelo;

public class Curso {

    private long id;
    private String descricao;
    private int quantidadeModulos;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidadeModulos() {
        return quantidadeModulos;
    }

    public void setQuantidadeModulos(int quantidadeModulos) {
        this.quantidadeModulos = quantidadeModulos;
    }

}
