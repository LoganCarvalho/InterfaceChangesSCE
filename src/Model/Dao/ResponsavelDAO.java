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
        int idInsercao=0;
        StringBuilder sql = new StringBuilder();
            try {
             sql.append("insert into cantinaescolaparaalteracao.usuario(senha_usuario, login_usuario, tipo_usuario)");
             sql.append(" values(?,?,'R'); ");
             PreparedStatement stmt1 = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);// o return generated keys retorna o ultimo id da tabela que passou pela inserção, desde de que este campo esteja como AutoIncrement.
             stmt1.setString(1, responsavel.getSenha());
             stmt1.setString(2, responsavel.getLogin());
             stmt1.executeUpdate();

             //Pegando resultado do generated keys
             ResultSet rs = stmt1.getGeneratedKeys();
             rs.next();
             idInsercao = rs.getInt(1);             

            sql.append(" insert into cantinaescolaparaalteracao.responsavel(cpf_responsavel, nome_responsavel, telefone_responsavel, email_responsavel, ativo, id_usuario)");
            sql.append(" values(?,?,?,?,1,?)");
            PreparedStatement stmt = conexao.prepareStatement(sql.toString());
            stmt.setString(1, responsavel.getCpf());
            stmt.setString(2, responsavel.getNome());
            stmt.setString(3, responsavel.getTelefone());
            stmt.setString(4, responsavel.getEmail());  
            stmt.setString(5, Integer.toString(idInsercao));
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
        StringBuilder sql = new StringBuilder();
        try {
            sql.append("delete from cantinaescolaparaalteracao.responsavel");
            sql.append(" where cpf = ?");
            PreparedStatement stmt = conexao.prepareStatement(sql.toString());
            stmt.setString(1, responsavel.getCpf());
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
    
     public int update(Responsavel responsavel) throws Exception {
        
        Connection conexao = ConnectionFactory.getConnection();
        int resposta = 0;
        StringBuilder sql = new StringBuilder();
        try {
            sql.append("UPDATE cantinaescolaparaalteracao.responsavel SET");
            sql.append("nome_responsavel = ? ,telefone_responsavel = ? ,email_responsavel = ? ");
            sql.append(" WHERE cpf = ?");
            PreparedStatement stmt = conexao.prepareStatement(sql.toString());
            stmt.setString(1, responsavel.getNome());
            stmt.setString(2, responsavel.getTelefone());
            stmt.setString(3, responsavel.getEmail()); 
            stmt.setString(4, responsavel.getCpf());
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
    public boolean consultar(Responsavel responsavel) throws Exception {

        Connection conexao = ConnectionFactory.getConnection();
        ResultSet resposta = null;
        boolean ok = false;
        StringBuilder sql = new StringBuilder();

        try {
            sql.append("select * from cantinaescolaparaalteracao.responsavel");
            sql.append(" where login_usuario LIKE '%'  ?  '%' ");
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
