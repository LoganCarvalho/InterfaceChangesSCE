
package Model.Dao;

import Model.Bean.ProdutoComida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ComidaDAO {
    
public int incluir(ProdutoComida produtoComida) throws Exception {
  
    Connection conexao = ConnectionFactory.getConnection();
        int resposta = 0;
        StringBuilder sql = new StringBuilder();
       
        try {
            sql.append("insert into cantinaescolaparaalteracao.produto_comida(codigo_comida, nome_comida, quantidade_comida, preco_comida, disponivel_comida, ingredientes)");
            sql.append(" values(?,?,?,?, 's',?);");
            PreparedStatement stmt = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);// o return generated keys retorna o ultimo id da tabela que passou pela inserção, desde de que este campo esteja como AutoIncrement.
            stmt.setString(1, produtoComida.getCodigo());           
            stmt.setString(2, produtoComida.getNome());
            stmt.setInt(3, produtoComida.getQuantidade());
            stmt.setString(4, produtoComida.getPreco());
            stmt.setString(5, produtoComida.getIngredientes());
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

    public int excluir(ProdutoComida produtoComida) throws Exception {
        
        Connection conexao = ConnectionFactory.getConnection();
        int resposta = 0;
        StringBuilder sql = new StringBuilder();
        try {
            sql.append("delete from cantinaescolaparaalteracao.produto_comida");
            sql.append(" where codigo_comida = ?");
            PreparedStatement stmt = conexao.prepareStatement(sql.toString());
            stmt.setString(1, produtoComida.getCodigo());
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
    
     public int update(ProdutoComida produtoComida) throws Exception {
        
        Connection conexao = ConnectionFactory.getConnection();
        int resposta = 0;
        StringBuilder sql = new StringBuilder();
        try {
            sql.append("UPDATE cantinaescolaparaalteracao.produto_comida SET");
            sql.append(" nome_comida = ?, qunatidade_comida = ?, preco_comida = ? , ingredientes = ?");
            sql.append(" WHERE codigo_comida = ?");
            PreparedStatement stmt = conexao.prepareStatement(sql.toString());
            stmt.setString(1, produtoComida.getNome());
            stmt.setInt(2, produtoComida.getQuantidade());
            stmt.setString(3, produtoComida.getPreco()); 
            stmt.setString(5, produtoComida.getIngredientes());
            stmt.setString(6, produtoComida.getCodigo());
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

    //Verificar se eu devo retornar um responsável ao invés de um bool
 /*   public boolean consultar(ProdutoComida produtoComida) throws Exception {

        Connection conexao = ConnectionFactory.getConnection();
        ResultSet resposta = null;
        boolean ok = false;
        StringBuilder sql = new StringBuilder();

        try {
            sql.append("select * from cantinaescolaparaalteracao.produto_comida");
            sql.append(" where codigo_comida LIKE '%'  ?  '%' ");
            PreparedStatement stmt = conexao.prepareStatement(sql.toString());
            stmt.setString(1, produtoComida.getLogin());

            resposta = stmt.executeQuery();
            while (produtoComida.next()) {
                produtoComida.setLogin(resposta.getString("login_usuario"));

                ok = true;
            }
        } catch (SQLException error) {
            System.out.println(error.getMessage());
        } finally {
            if (conexao != null) {
                ConnectionFactory.FecharConexao(conexao, null, resposta);
            }
        }
        return ok;
    }*/
}
