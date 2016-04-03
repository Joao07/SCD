package dao;

import Factory.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Ocorrencia;

public class OcorrenciaDAO {

    private final Connection conexao;
    private PreparedStatement sql;
    private ResultSet registro;

    public OcorrenciaDAO() {
        conexao = new Conexao().getConexao();
    }

    public void Gravar(Ocorrencia ocorrencia) {
        try {
            String query = "insert into ocorrencia (descricaoOcorrencia,observacao,data)values(?,?,?)";

            sql = conexao.prepareStatement(query);
            sql.setLong(1, ocorrencia.getId_ocorrencia());
            sql.execute();
            JOptionPane.showMessageDialog(null,"Cadastrado com sucesso !!!");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void Excluir(Ocorrencia ocorrencia) {
        try {
            String query = "delete from ocorrencia where id_ocorrencia = ? ";
            sql = conexao.prepareStatement(query);
            sql.setLong(1, ocorrencia.getId_ocorrencia());
            sql.execute();
        } catch (SQLException ex) {
            Logger.getLogger(OcorrenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Ocorrencia> getOcorrencia() {
        try {
            List<Ocorrencia> ocorrencias = new ArrayList<>();
            String query = "select * from ocorrencia limit 100";
            sql = conexao.prepareStatement(query);
            registro = sql.executeQuery();
            
            while(registro.next()){
                Ocorrencia ocorrencia = new Ocorrencia();
                ocorrencia.setDescricaoOcorrencia(registro.getString("descricao_ocorrencia"));
                ocorrencia.setId_ocorrencia(registro.getInt("id_descricao"));
                ocorrencia.setData(registro.getInt("observacao"));
                ocorrencias.add(ocorrencia);
            }
            return ocorrencias;
        } catch (SQLException ex) {
            return null;
        }
    }
}
