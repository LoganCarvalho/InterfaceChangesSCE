package Model.Dao;

import Model.Bean.Responsavel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResponsavelDAO {
    
    //Modelo a ser seguido
    public int incluir(Responsavel responsavel) throws Exception {

          Connection conexao = ConnectionFactory.getConnection();
        int resposta = 0;
        StringBuilder sql = new StringBuilder();
        try {
             sql.append("insert into cantinaescolaparaalteracao.responsavel(cpf_responsavel,nome_responsavel,telefone_responsavel,email_responsavel,ativo,nome_usuario,senha_usuario)");
             sql.append(" values(?,?,?,?,1,?,?)");     
    PreparedStatement stmt = conexao.prepareStatement(sql.toString());
    stmt.setString(1,responsavel.getCpf());
    stmt.setString(2,responsavel.getNome());
    stmt.setString(3,responsavel.getTelefone());
    stmt.setString(4,responsavel.getEmail());
    stmt.setString(5,responsavel.getLogin());
    stmt.setString(6,responsavel.getSenha());
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

    public int excluir(Responsavel responsavel) throws Exception {
        Connection conexao = ConnectionFactory.getConnection();
        int resposta = 0;
        try {
            Statement sentenca = conexao.createStatement();
            String sql = "delete from cantinaescolaparaalteracao.responsavel "
                    + "where cpf = **";
            resposta = sentenca.executeUpdate(sql);
        } catch (SQLException erro) {

        } finally {
            if (conexao != null) {
                ConnectionFactory.FecharConexao(conexao);
            }
        }
        return resposta;
    }

    //Verificar se eu devo retornar um responsável ao invés de um bool
    public boolean consultar(Responsavel responsavel) throws Exception {
        
        Connection conexao = ConnectionFactory.getConnection();
        ResultSet resposta = null;
        boolean ok = false;
        StringBuilder sql = new StringBuilder();
        
        try {
            sql.append("select * from cantinaescolaparaalteracao.responsavel");
            sql.append("where login_usuario LIKE %?% ");
            PreparedStatement stmt = conexao.prepareStatement(sql.toString());
            stmt.setString(1, responsavel.getLogin());
              
            resposta = stmt.executeQuery();
            while (resposta.next()) {
                responsavel.setLogin(resposta.getString("login_usuario"));
               
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

}
