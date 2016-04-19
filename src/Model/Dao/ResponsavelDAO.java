
package Model.Dao;

import Model.Bean.Responsavel;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ResponsavelDAO {
    
     public int incluir(Responsavel responsavel) {

        Connection conexao =  new ConnectionFactory().getConnection();
        int resposta = 0;
        try {
            Statement sentence = conexao.createStatement();
            String sql = "insert into projeto_aereo.cliente "+
                     "(nome,dt_nascimento, cpf) "+
                     "values('" + responsavel.getCep()+ "','" + responsavel.getCpf()+ "','" + responsavel.getEmail()+ "'"
                                + responsavel.getLogin()+ "','" + responsavel.getNome()+ "','" + responsavel.getSenha()+ "'"
                                + responsavel.getTelefone()+ "')";
            resposta = sentence.executeUpdate(sql);
        } catch (SQLException error) {     
            
          }         
        finally {
            return resposta;
        }

    }
    
    
}
