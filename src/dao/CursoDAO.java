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
import modelo.Curso;

public class CursoDAO {

    private final Connection conexao;
    private PreparedStatement sql;
    private ResultSet registro;

    public CursoDAO() {
        conexao = new Conexao().getConexao();
    }

    public void Gravar(Curso curso) {
        String query = "INSERT INTO curso(\n"
                + "    descricao_curso)\n"
                + "    VALUES (?);";
        try {
            sql = conexao.prepareStatement(query);

            sql.setString(1, curso.getDescricao());
            sql.execute();
            JOptionPane.showMessageDialog(null, "Curso cadastrado com Sucesso !!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void Excluir(Curso curso) {
        String query = "delete from curso where id_curso = ? ";
        try {
            sql = conexao.prepareStatement(query);

            sql.setLong(1, curso.getId());
            sql.execute();
            JOptionPane.showMessageDialog(null, "Curso excluido com Sucesso !!!");
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Curso> getCurso() {
        try {
            List<Curso> cursos = new ArrayList<>();
            String query = "select * from curso limit 100";

            sql = conexao.prepareStatement(query);

            registro = sql.executeQuery();

            while (registro.next()) {
                Curso curso = new Curso();
                curso.setDescricao(registro.getString("descricao_curso"));
                curso.setId(registro.getLong("id_curso"));

                cursos.add(curso);
            }
            return cursos;
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Curso> Pesquisar(String descricao) {
        try {
            List<Curso> cursos = new ArrayList<>();
            String query = "select * from curso where descricao_curso ilike '%" + descricao + "%'";

            sql = conexao.prepareStatement(query);

            registro = sql.executeQuery();

            while (registro.next()) {
                Curso curso = new Curso();
                curso.setDescricao(registro.getString("descricao_curso"));
                curso.setId(registro.getLong("id_curso"));

                cursos.add(curso);
            }
            return cursos;
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
