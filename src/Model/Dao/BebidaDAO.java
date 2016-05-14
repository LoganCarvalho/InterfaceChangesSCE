
package Model.Dao;
import Model.Bean.ProdutoBebida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class BebidaDAO {
    
public int incluir(ProdutoBebida produtoBebida) throws Exception {
  
    Connection conexao = ConnectionFactory.getConnection();
        int resposta = 0;
        StringBuilder sql = new StringBuilder();
       
        try {
            sql.append("insert into CantinaEscola.produto_bebida(codigo_bebida, nome_bebida, preco_bebida, quantidade_bebida, disponivel_bebida, fornecedor)");
            sql.append(" values(?,?,?,?, 's',?);");
            PreparedStatement stmt = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);// o return generated keys retorna o ultimo id da tabela que passou pela inserção, desde de que este campo esteja como AutoIncrement.
            stmt.setString(1, produtoBebida.getCodigo());           
            stmt.setString(2, produtoBebida.getNome());
            stmt.setDouble(3, produtoBebida.getPreco());
            stmt.setInt(4, produtoBebida.getQuantidade());
            stmt.setString(5, produtoBebida.getFornecedor());
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

    public int excluir(ProdutoBebida produtoBebida) throws Exception {
        
        Connection conexao = ConnectionFactory.getConnection();
        int resposta = 0;
        StringBuilder sql = new StringBuilder();
        try {
            sql.append("delete from CantinaEscola.produto_bebida");
            sql.append(" where codigo_bebida = ?");
            PreparedStatement stmt = conexao.prepareStatement(sql.toString());
            stmt.setString(1, produtoBebida.getCodigo());
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
    
     public int update(ProdutoBebida produtoBebida) throws Exception {
        
        Connection conexao = ConnectionFactory.getConnection();
        int resposta = 0;
        StringBuilder sql = new StringBuilder();
        try {
            sql.append("UPDATE CantinaEscola.produto_bebida SET");
            sql.append(" nome_bebida = ?, preco_bebida = ? , qunatidade_bebida = ?, fornecedor = ?");
            sql.append(" WHERE codigo_comida = ?");
            PreparedStatement stmt = conexao.prepareStatement(sql.toString());
            stmt.setString(1, produtoBebida.getNome());
            stmt.setDouble(2, produtoBebida.getPreco()); 
            stmt.setInt(3, produtoBebida.getQuantidade());
            stmt.setString(5, produtoBebida.getFornecedor());
            stmt.setString(6, produtoBebida.getCodigo());
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
            sql.append("select * from CantinaEscola.produto_comida");
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
