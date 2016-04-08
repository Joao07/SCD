package dao;

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

    private Connection conexao;
    private PreparedStatement sql;
    private ResultSet registro;

    public boolean Gravar(Curso curso) {
//        conexao = Conexao.getConexao();
        String query = "INSERT INTO curso(\n"
                + "    descricao_curso,quantidadeModulos)\n"
                + "    VALUES (?);";
        try {
            sql = conexao.prepareStatement(query);
            sql.setString(1, curso.getDescricao());
            sql.setInt(2, curso.getQuantidadeModulos());
            sql.execute();
            JOptionPane.showMessageDialog(null, "Curso cadastrado com Sucesso !!!");
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return false;
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

    public List<Curso> buscarTodos() {
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
            String query = "select * from curso where descricao_curso ilike '%?%'";
            sql.setString(1, descricao);
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
