package Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexao {

    private static Connection connection = null;

    public static Connection getConexao() {

        try {
            if (connection == null) {
                // senha postegre97
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/X9", "postgres", "postegre97");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
}
