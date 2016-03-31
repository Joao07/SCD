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
    
    public void Gravar(Disciplina disciplina){
        try {
            String query = "INSERT INTO curso(\n"
                + "descricao_disciplina"
                + "carga_horaria)"
                + "VALUES (?,?)";
            
            sql = conexao.prepareStatement(query);
            sql.setString(1,disciplina.getDecricao());
            sql.setLong(2, disciplina.getCarga_horaria());
            
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
