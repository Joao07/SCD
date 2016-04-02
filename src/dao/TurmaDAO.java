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
import modelo.Turma;

public class TurmaDAO {

    private final Connection conexao;
    private PreparedStatement sql;
    private ResultSet registro;

    public TurmaDAO() {
        conexao = new Conexao().getConexao();
    }

    public void Gravar(Turma turma) {
      
            String query = "insert into turma(descricao_turma,turno_turma,ano_turma) values (?,?,?)";
        try {
            sql = conexao.prepareStatement(query);

            sql.setString(1, turma.getDescricao());
            sql.setString(2, turma.getTurno());
            sql.setLong(3, turma.getAno());

            sql.execute();
            JOptionPane.showMessageDialog(null, "Turma cadastrada com sucesso !!!");

        } catch (SQLException ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Turma> getTurma() {
        try {
            List<Turma> Turmas = new ArrayList<>();

            String query = "SELECT * FROM TURMA LIMIT 100";
            sql = conexao.prepareStatement(query);

            registro = sql.executeQuery();

            while (registro.next()) {
                Turma turma = new Turma();
                turma.setId(registro.getLong("id_Turma"));
                turma.setDescricao(registro.getString("descricao_turma"));
                turma.setDescricao(registro.getString("turno_turma"));
                Turmas.add(turma);

            }
            return Turmas;
        } catch (SQLException ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
}
