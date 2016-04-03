package dao;

import Factory.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Professor;

public class ProfessorDAO {
    private Connection conexao;
    private PreparedStatement sql;
    private ResultSet registro;
    
    public ProfessorDAO(){
        conexao = new Conexao().getConexao();
    }
    
    public void Gravar(Professor professor){
        try {
            String query = "insert into professor(nome,sexo,cpf,cep,rua,numero,bairro,cidade,cod_siape,email,celular,telefone_fixo) values (?,?,?,?,?,?,?,?,?,?,?,?)";
            
            sql = conexao.prepareStatement(query);
            sql.setString(1, professor.getNome());
            sql.setString(2, professor.getSexo());
            sql.setString(3, professor.getCPF());
            sql.setString(4, professor.getCEP());
            sql.setString(5, professor.getRua());
            sql.setLong(6, professor.getNumero());
            sql.setString(7, professor.getBairro());
            sql.setString(8, professor.getCidade());
            sql.setString(9, professor.getCodSiape());
            sql.setString(10, professor.getEmail());
            sql.setString(11, professor.getCelular());
            sql.setString(12, professor.getTelefoneFixo());
            sql.execute();
            
            JOptionPane.showMessageDialog(null, "Professor cadastrado com sucesso !!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }
}
