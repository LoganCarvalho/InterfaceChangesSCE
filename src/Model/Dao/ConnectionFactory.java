package Model.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionFactory {

    private static Connection conn;

    public Connection getConnection() {

        //MYSQL      
        try {
            String nomeDriver = "com.mysql.jdbc.Driver";
            String usuario = "root";
            String senha = "";
            String url = "jdbc:mysql://localhost";

            //Carregar o driver JDBC
            Class.forName(nomeDriver);
            //Criar uma conexão com o banco
            conn = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
    
        // Chamando métodos para fechar as conexões
    public static void FecharConexao(Connection conn, PreparedStatement pstm, ResultSet rs) throws Exception {
        Fechar(conn, pstm, rs);
    }
    
    public static void FecharConexao(Connection conn, PreparedStatement pstm) throws Exception {
        Fechar(conn, pstm, null);
    }
    
    public static void FecharConexao(Connection conn) throws Exception {
        Fechar(conn, null, null);
    }

    private static void Fechar(Connection conn,  PreparedStatement pstm, ResultSet rs) throws Exception {
        try {
            if (rs != null) rs.close( );
            if (pstm != null)pstm.close( );
            if (conn != null)conn.close( );
        } catch (Exception e) {
            throw new Exception(e.getMessage( ));
        }
    }
}
