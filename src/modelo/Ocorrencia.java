
package modelo;

public class Ocorrencia {
    
    private long id_ocorrencia;
    private String descricaoOcorrencia,observacao;
    private int data;

    public String getDescricaoOcorrencia() {
        return descricaoOcorrencia;
    }

    public void setDescricaoOcorrencia(String descricaoOcorrencia) {
        this.descricaoOcorrencia = descricaoOcorrencia;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public long getId_ocorrencia() {
        return id_ocorrencia;
    }

    public void setId_ocorrencia(long id_ocorrencia) {
        this.id_ocorrencia = id_ocorrencia;
    }
    
    
            
}
