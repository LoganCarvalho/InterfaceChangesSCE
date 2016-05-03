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
        try {
            String sql = "insert into cantinaescolaparaalteracao.responsavel(cpf_responsavel,nome_responsavel,telefone_responsavel,email_responsavel,ativo,nome_usuario,senha_usuario) values (?,?,?,?,1,?,?)";
           
    PreparedStatement stmt = conexao.prepareStatement(sql);
    stmt.setString(1,responsavel.getCpf());
    stmt.setString(2,responsavel.getNome());
    stmt.setString(3,responsavel.getTelefone());
    stmt.setString(4,responsavel.getEmail());
    stmt.setString(5,responsavel.getLogin());
    stmt.setString(6,responsavel.getSenha());
    stmt.execute();
    
        } catch (SQLException error) {
             System.out.println(error.getMessage());
        } finally {
            if (conexao != null) {
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
            String sql = "delete from *** "
                    + "where *** = **";
            resposta = sentenca.executeUpdate(sql);
        } catch (SQLException erro) {

        } finally {
            if (conexao != null) {
                ConnectionFactory.FecharConexao(conexao);
            }
        }
        return resposta;
    }

    public boolean consultar(Responsavel responsavel) throws Exception {
        Connection conexao = ConnectionFactory.getConnection();
        ResultSet resposta = null;
        boolean ok = false;
        try {
            Statement sentenca = conexao.createStatement();
            String sql = "select *** from *** "
                    + "where cpf=" + "'" + responsavel.getCpf() + "'";
            resposta = sentenca.executeQuery(sql);
            while (resposta.next()) {
                responsavel.setNome(resposta.getString("campo da tela"));
                responsavel.setCpf(resposta.getString("campo da tela"));
                responsavel.setEmail(resposta.getString("campo da tela"));
                responsavel.setTelefone(resposta.getString("campo da tela"));
                ok = true;
            }
        } catch (SQLException erro) {

        } finally {
            if (conexao != null) {
                ConnectionFactory.FecharConexao(conexao, null, resposta);
            }
        }
        return ok;
    }

}
