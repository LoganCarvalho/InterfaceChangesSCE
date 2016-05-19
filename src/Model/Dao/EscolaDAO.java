
package Model.Dao;

import Model.Bean.Escola;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class EscolaDAO {
    
    public int incluir(Escola escola) throws Exception {
  
    Connection conexao = ConnectionFactory.getConnection();
        int resposta = 0;
        StringBuilder sql = new StringBuilder();
       
        try {
            sql.append("insert into CantinaEscola.escola(nome_escola,");
            sql.append("endereco_escola, telefone_escola, email_escola, cnpj_escola)");
            sql.append(" values(?,?,?,?,?)");
            PreparedStatement stmt = conexao.prepareStatement(sql.toString());
            stmt.setString(1, escola.getNomeEscola());           
            stmt.setString(2, escola.getEnderecoEscola()); 
            stmt.setString(3, escola.getTelefoneEscola());
            stmt.setString(4, escola.getEmailEscola());
            stmt.setString(5, escola.getCnpjEscola());
            stmt.executeUpdate();
            
        } catch (SQLException error) {
            System.out.println(error.getMessage());
        } finally {
            if (conexao != null) {
                resposta = 1;
                ConnectionFactory.FecharConexao(conexao);
            }
        }
        return resposta;
    
    }
    
}
