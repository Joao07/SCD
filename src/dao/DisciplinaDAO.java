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
import modelo.Disciplina;

public class DisciplinaDAO {

    private Connection conexao;
    private PreparedStatement sql;
    private ResultSet registro;

    public void Gravar(Disciplina disciplina) {
        try {
            conexao = Conexao.getConexao();
            String query = "INSERT INTO disciplina(descricao_disciplina,carga_horaria) VALUES (?,?)";

            sql = conexao.prepareStatement(query);
            sql.setString(1, disciplina.getDescricao());
            sql.setLong(2, disciplina.getCargaHoraria());
            sql.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Disciplina> buscarTodos() {
        List<Disciplina> disciplinas = new ArrayList<>();
        try {
            sql = Conexao.getConexao().prepareStatement("SELECT * FROM disciplina");
            registro = sql.executeQuery();
            while (registro.next()) {
                Disciplina disciplina = new Disciplina();
                disciplina.setCargaHoraria(registro.getInt("carga_horaria"));
                disciplina.setDescricao(registro.getString("descricao_disciplina"));
                disciplina.setId(registro.getInt("id_disciplina"));
                disciplinas.add(disciplina);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return disciplinas;
    }

    public boolean remover(long id) {
        try {
            sql = Conexao.getConexao().prepareStatement("DELETE FROM disciplina WHERE id_disciplina=?");
            sql.setLong(1, id);
            return sql.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
}
