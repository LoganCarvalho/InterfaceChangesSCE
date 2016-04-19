package Model.Dao;

import Model.Bean.Responsavel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResponsavelDAO {

    public int incluir(Responsavel responsavel) throws Exception {

        Connection conexao = ConnectionFactory.getConnection();
        int resposta = 0;
        try {
            Statement sentence = conexao.createStatement();
            String sql = "insert into *** "
                    + "(nome,dt_nascimento, cpf) "
                    + "values('" + responsavel.getCpf() + "','" + responsavel.getEmail() + "'"
                    + responsavel.getLogin() + "','" + responsavel.getNome() + "','" + responsavel.getSenha() + "'"
                    + responsavel.getTelefone() + "')";
            resposta = sentence.executeUpdate(sql);
        } catch (SQLException error) {

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
