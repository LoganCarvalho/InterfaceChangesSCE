package Model.Dao;

import Model.Bean.Aluno;
import Model.Bean.Usuario;
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
            sql.append("insert into CantinaEscola.usuario(senha_usuario, login_usuario, tipo_usuario)");
            sql.append(" values(?,?,'A');");
            PreparedStatement stmt = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);// o return generated keys retorna o ultimo id da tabela que passou pela inserção, desde de que este campo esteja como AutoIncrement.
            stmt.setString(1, aluno.getSenha());           
            stmt.setString(2, aluno.getLogin());
            stmt.executeUpdate();
              
            //Pegando resultado do generated keys
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            idInsercao = rs.getInt(1);
                         
            sql1.append(" insert into CantinaEscola.aluno(matricula_aluno,turno_aluno,turma_aluno,nome_aluno,id_usuario,id_responsavel)");
            sql1.append(" values(?,?,?,?,?,?);");
            PreparedStatement stmt2 = conexao.prepareStatement(sql1.toString());
            stmt2.setInt(1, aluno.getMatricula());
            stmt2.setString(2, aluno.getTurno());
            stmt2.setString(3, aluno.getTurma());
            stmt2.setString(4, aluno.getNome());
            stmt2.setInt(5, (idInsercao));
            stmt2.setInt(6, aluno.getIdResponsavel());
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
        StringBuilder sql = new StringBuilder();
        try {
            sql.append("delete from CantinaEscola.aluno");
            sql.append(" where matricula_aluno = ?");
            PreparedStatement stmt = conexao.prepareStatement(sql.toString());
            stmt.setInt(1, aluno.getMatricula());
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
    

     public int update(Aluno aluno) throws Exception {
        
        Connection conexao = ConnectionFactory.getConnection();
        int resposta = 0;
        StringBuilder sql = new StringBuilder();
        try {
            sql.append("UPDATE CantinaEscola.aluno SET");
            sql.append(" saldo_aluno = ? ");
            sql.append(" WHERE matricula_aluno = ?");
            PreparedStatement stmt = conexao.prepareStatement(sql.toString());
            stmt.setDouble(1, aluno.getSaldo());
            stmt.setInt(2, aluno.getMatricula());
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

     public int alterarAluno(Aluno aluno) throws Exception {
        
        Connection conexao = ConnectionFactory.getConnection();
        int resposta = 0;
        StringBuilder sql = new StringBuilder();
        try {
            sql.append("UPDATE CantinaEscola.aluno SET");
            sql.append(" nome_aluno = ? ,turno_aluno = ? ,turma_aluno = ? ");
            sql.append(" WHERE matricula_aluno = ?");
            PreparedStatement stmt = conexao.prepareStatement(sql.toString());
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getTurno());
            stmt.setString(3, aluno.getTurma()); 
            stmt.setInt(4, aluno.getMatricula());
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
     
    public boolean consultarSaldo(Aluno aluno) throws Exception {

        Connection conexao = ConnectionFactory.getConnection();
        ResultSet resposta = null;
        boolean ok = false;
        StringBuilder sql = new StringBuilder();

        try {
            sql.append("select * from CantinaEscola.aluno");
            sql.append(" where matricula_aluno = ? ");
            PreparedStatement stmt = conexao.prepareStatement(sql.toString());
            stmt.setInt(1, aluno.getMatricula());

            resposta = stmt.executeQuery();
            while (resposta.next()) {            
               // aluno.setNome(resposta.getString("nome_aluno"));
                aluno.setSaldo(Integer.parseInt(resposta.getString("saldo_aluno")));
                //aluno.setTurma(resposta.getString("turma_aluno"));
                //aluno.setTurno(resposta.getString("turno_aluno"));
                   
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
    
     public boolean consultarSaldoAluno(Aluno aluno, Usuario usuario) throws Exception {

        Connection conexao = ConnectionFactory.getConnection();
        ResultSet resposta = null;
        boolean ok = false;
        StringBuilder sql = new StringBuilder();

        try {
            sql.append("select saldo_aluno from CantinaEscola.aluno");
            sql.append(" inner join CantinaEscola.usuario on CantinaEscola.aluno.id_usuario = CantinaEscola.usuario.id_usuario");
            sql.append(" where CantinaEscola.usuario.login_usuario = " +usuario.getLogin()+" ");
            sql.append(" and CantinaEscola.usuario.senha_usurio = " +usuario.getSenha()+" ");
            PreparedStatement stmt = conexao.prepareStatement(sql.toString());

            resposta = stmt.executeQuery();
            while (resposta.next()) {            
               // aluno.setNome(resposta.getString("nome_aluno"));
                aluno.setSaldo(Integer.parseInt(resposta.getString("saldo_aluno")));
                //aluno.setTurma(resposta.getString("turma_aluno"));
                //aluno.setTurno(resposta.getString("turno_aluno"));
                   
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
    
     public boolean consultar(Aluno aluno) throws Exception {

        Connection conexao = ConnectionFactory.getConnection();
        ResultSet resposta = null;
        boolean ok = false;
        StringBuilder sql = new StringBuilder();

        try {
            sql.append("select * from CantinaEscola.aluno");
            sql.append(" where matricula_aluno = ? or nome_aluno = ? ");
            PreparedStatement stmt = conexao.prepareStatement(sql.toString());
            stmt.setInt(1, aluno.getMatricula());
            stmt.setString(2, aluno.getNome());
            
            resposta = stmt.executeQuery();
            while (resposta.next()) { 
                aluno.setMatricula(Integer.parseInt(resposta.getString("matricula_aluno")));
                aluno.setNome(resposta.getString("nome_aluno"));
                aluno.setSaldo(Integer.parseInt(resposta.getString("saldo_aluno")));
                aluno.setTurma(resposta.getString("turma_aluno"));
                aluno.setTurno(resposta.getString("turno_aluno"));
                   
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
