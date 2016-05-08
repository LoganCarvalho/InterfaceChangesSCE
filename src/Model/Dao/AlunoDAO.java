package Model.Dao;

import Model.Bean.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jcarvalho
 */
public class AlunoDAO {

    //Modelo a ser seguido
    public int incluir(Aluno aluno) throws Exception {

        Connection conexao = ConnectionFactory.getConnection();
        int resposta = 0;
        int idInsercao = 0;
        StringBuilder sql = new StringBuilder();
        StringBuilder sql1 = new StringBuilder();
       
        try {
            sql.append("insert into cantinaescolaparaalteracao.usuario(senha_usuario, login_usuario, tipo_usuario)");
            sql.append(" values(?,?,A);");
            PreparedStatement stmt = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);// o return generated keys retorna o ultimo id da tabela que passou pela inserção, desde de que este campo esteja como AutoIncrement.
            stmt.setString(1, aluno.getSenha());           
            stmt.setString(2, aluno.getLogin());
            stmt.executeUpdate();
              
            //Pegando resultado do generated keys
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            idInsercao = rs.getInt(1);
                         
            sql1.append(" insert into cantinaescolaparaalteracao.aluno(matricula_aluno,turno_aluno,turma_aluno,nome_aluno,id_usuario)");
            sql1.append(" values(?,?,?,?,?);");
            PreparedStatement stmt2 = conexao.prepareStatement(sql1.toString());
            stmt2.setString(1, aluno.getMatricula());
            stmt2.setString(2, aluno.getTurno());
            stmt2.setString(3, aluno.getTurma());
            stmt2.setString(4, aluno.getNome());
            stmt2.setString(5, Integer.toString(idInsercao));
            stmt2.executeUpdate();

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

    public int excluir(Aluno aluno) throws Exception {
        Connection conexao = ConnectionFactory.getConnection();
        int resposta = 0;
        try {
            Statement sentenca = conexao.createStatement();
            String sql = "delete from cantinaescolaparaalteracao.aluno "
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
    public boolean consultar(Aluno aluno) throws Exception {

        Connection conexao = ConnectionFactory.getConnection();
        ResultSet resposta = null;
        boolean ok = false;
        StringBuilder sql = new StringBuilder();

        try {
            sql.append("select * from cantinaescolaparaalteracao.aluno");
            sql.append(" where *** LIKE '%'  ?  '%' ");
            PreparedStatement stmt = conexao.prepareStatement(sql.toString());
            stmt.setString(1, aluno.getMatricula());

            resposta = stmt.executeQuery();
            while (resposta.next()) {
                aluno.setLogin(resposta.getString("campo_banco"));

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
