
package modelo;

public class Disciplina {

    private long id;
    private String descricao;
    private long cargaHoraria;

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

    public long getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(long cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }


}
