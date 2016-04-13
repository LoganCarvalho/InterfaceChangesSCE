
package Testes;

import Model.Dao.ConnectionFactory;
import java.sql.Connection;


public class TestarConexao {

    public static void main(String[] args) {
         Connection conexao = new ConnectionFactory().getConnection();
         System.out.println("Conexão aberta!");        
    }
  
}
