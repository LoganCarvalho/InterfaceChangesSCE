
package Model.Dao;

import Model.Bean.ProdutoComida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComidaDAO {
    
public int incluir(ProdutoComida produtoComida) throws Exception {
  
    Connection conexao = ConnectionFactory.getConnection();
        int resposta = 0;
        StringBuilder sql = new StringBuilder();
       
        try {
            sql.append("insert into CantinaEscola.produto_comida(nome_comida,");
            sql.append("quantidade_comida, preco_comida, disponivel_comida, ingredientes)");
            sql.append(" values(?,?,?,'S',?)");
            PreparedStatement stmt = conexao.prepareStatement(sql.toString());
            stmt.setString(1, produtoComida.getNome());           
            stmt.setInt(2, produtoComida.getQuantidade()); 
            stmt.setDouble(3, produtoComida.getPreco());
            stmt.setString(4, produtoComida.getIngredientes());
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
            sql.append("delete from CantinaEscola.produto_comida");
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
            sql.append("UPDATE CantinaEscola.produto_comida SET");
            sql.append(" nome_comida = ?, quantidade_comida = ?, preco_comida = ? , ingredientes = ?");
            sql.append(" WHERE codigo_comida = ?");
            PreparedStatement stmt = conexao.prepareStatement(sql.toString());
            stmt.setString(1, produtoComida.getNome());
            stmt.setInt(2, produtoComida.getQuantidade());
            stmt.setDouble(3, produtoComida.getPreco()); 
            stmt.setString(4, produtoComida.getIngredientes());
            stmt.setString(5, produtoComida.getCodigo());
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

     public boolean consultar(ProdutoComida produtoComida) throws Exception {

        Connection conexao = ConnectionFactory.getConnection();
        ResultSet resposta = null;
        boolean ok = false;
        StringBuilder sql = new StringBuilder();

        try {
            sql.append("select * from CantinaEscola.produto_comida");
            sql.append(" where nome_comida LIKE '%" +produtoComida.getNome()+"%' and disponivel_comida = 'S' ");
            PreparedStatement stmt = conexao.prepareStatement(sql.toString());

            resposta = stmt.executeQuery();
             while (resposta.next()) {
                produtoComida.setCodigo(resposta.getString("codigo_comida"));
                produtoComida.setNome(resposta.getString("nome_comida"));
                produtoComida.setPreco(resposta.getDouble("preco_comida"));
                produtoComida.setIngredientes(resposta.getString("ingredientes"));
                produtoComida.setQuantidade(resposta.getInt("quantidade_comida"));
                
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
     }     
     
     
     public boolean consultarComidasDisponiveis(ProdutoComida produtoComida) throws Exception {

        Connection conexao = ConnectionFactory.getConnection();
        ResultSet resposta = null;
        boolean ok = false;
        StringBuilder sql = new StringBuilder();

        try {
            sql.append("select * from CantinaEscola.produto_comida");
            sql.append(" where disponivel_comida = 'S'");
            PreparedStatement stmt = conexao.prepareStatement(sql.toString());

            resposta = stmt.executeQuery();
             //List<ProdutoComida> listaProdutos  = new ArrayList<>();
             while (resposta.next()) {
               // ProdutoComida PC = new ProdutoComida();
                produtoComida.setCodigo(resposta.getString("codigo_comida"));
                produtoComida.setNome(resposta.getString("nome_comida"));
                produtoComida.setPreco(resposta.getDouble("preco_comida"));
                produtoComida.setIngredientes(resposta.getString("ingredientes"));
                //listaProdutos.add(PC);
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
     }     
     
     public List<ProdutoComida> getComida() throws Exception {
        
        List<ProdutoComida> comidas = new ArrayList();
        ProdutoComida comida;
        
        ProdutoComida produtoComida = new ProdutoComida();
        
        Connection conexao = ConnectionFactory.getConnection();
        ResultSet resposta = null;
        boolean ok = false;
        StringBuilder sql = new StringBuilder();
        
        try {            
            conexao = new ConnectionFactory().getConnection();
            sql.append("select * from CantinaEscola.produto_comida");
            sql.append(" where nome_comida LIKE ? ");
            
            PreparedStatement stmt = conexao.prepareStatement(sql.toString());
            stmt.setString(1, ("'%" + produtoComida.getNome() + "%'"));                     
            resposta = stmt.executeQuery();
            
            while (resposta.next()) {
                comida = new ProdutoComida();
                comida.setCodigo(resposta.getString("codigo_comida"));
                comida.setNome(resposta.getString("nome_comida"));
                comida.setPreco(Double.valueOf(resposta.getString("preco_comida")));
                comida.setIngredientes(resposta.getString("ingredientes"));
                comida.setQuantidade(resposta.getInt("quantidade_comida"));
                comidas.add(comida);
            }
            
        } catch (SQLException error) {
            System.out.println(error.getMessage());
        } finally {
            if (conexao != null) {
                ConnectionFactory.FecharConexao(conexao, null, resposta);
            }
        }
        return (comidas);
    }
       
       public int bloquear(ProdutoComida produtoComida) throws Exception {
        
        Connection conexao = ConnectionFactory.getConnection();
        int resposta = 0;
        StringBuilder sql = new StringBuilder();
        try {
            sql.append("UPDATE CantinaEscola.produto_comida SET");
            sql.append(" disponivel_comida = 'N'");
            sql.append(" WHERE codigo_comida = ?");
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
}
