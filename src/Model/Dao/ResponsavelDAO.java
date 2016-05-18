package Model.Dao;

import Model.Bean.Responsavel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ResponsavelDAO {

    //Modelo a ser seguido
    public int incluir(Responsavel responsavel) throws Exception {

        Connection conexao = ConnectionFactory.getConnection();
        int resposta = 0;
        int idInsercao=0;
        StringBuilder sql = new StringBuilder();
        StringBuilder sql1 = new StringBuilder();
            try {
             sql.append("insert into CantinaEscola.usuario(senha_usuario, login_usuario, tipo_usuario)");
             sql.append(" values(?,?,'R')");
             PreparedStatement stmt1 = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);// o return generated keys retorna o ultimo id da tabela que passou pela inserção, desde de que este campo esteja como AutoIncrement.
             stmt1.setString(1, responsavel.getSenha());
             stmt1.setString(2, responsavel.getLogin());
             stmt1.executeUpdate();

             //Pegando resultado do generated keys
             ResultSet rs = stmt1.getGeneratedKeys();
             rs.next();
             idInsercao = rs.getInt(1);             

            sql1.append(" insert into CantinaEscola.responsavel(cpf_responsavel, nome_responsavel, telefone_responsavel, email_responsavel, ativo, id_usuario)");
            sql1.append(" values(?,?,?,?,1,?)");
            PreparedStatement stmt = conexao.prepareStatement(sql1.toString());
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
            sql.append("UPDATE CantinaEscola.responsavel SET ativo= 0 ");
            sql.append(" where cpf_responsavel = ? ");
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
            sql.append("UPDATE CantinaEscola.responsavel SET");
            sql.append(" nome_responsavel = ? ,telefone_responsavel = ? ,email_responsavel = ? ");
            sql.append(" WHERE cpf_responsavel = ?");
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

     
      public boolean consultarPeloCPF(Responsavel responsavel) throws Exception {

        Connection conexao = ConnectionFactory.getConnection();
        ResultSet resposta = null;
        boolean ok = false;
        StringBuilder sql = new StringBuilder();

        try {
            sql.append("select * from CantinaEscola.responsavel");
            sql.append(" where cpf_responsavel LIKE '%" +responsavel.getCpf()+"%' and ativo = 1 ");
            PreparedStatement stmt = conexao.prepareStatement(sql.toString());
            //stmt.setString(1, responsavel.getNome());

            resposta = stmt.executeQuery();
            while (resposta.next()) {
                responsavel.setIdResponsavel(Integer.parseInt(resposta.getString("id_responsavel")));
                
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
   
    public boolean consultar(Responsavel responsavel) throws Exception {

        Connection conexao = ConnectionFactory.getConnection();
        ResultSet resposta = null;
        boolean ok = false;
        StringBuilder sql = new StringBuilder();

        try {
            sql.append("select * from CantinaEscola.responsavel");
            sql.append(" where nome_responsavel LIKE '%" +responsavel.getNome()+"%' and ativo = 1 ");
            PreparedStatement stmt = conexao.prepareStatement(sql.toString());
            //stmt.setString(1, responsavel.getNome());

            resposta = stmt.executeQuery();
            while (resposta.next()) {
                responsavel.setNome(resposta.getString("nome_responsavel"));
                responsavel.setCpf(resposta.getString("cpf_responsavel"));
                responsavel.setTelefone(resposta.getString("telefone_responsavel"));
                responsavel.setEmail(resposta.getString("email_responsavel"));

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
    
    public ArrayList<Responsavel> listarResponsavel() throws Exception {
        
        ArrayList<Responsavel> responsaveis = new ArrayList();
        Responsavel responsavel;
        
        Responsavel respon = new Responsavel();
        
        Connection conexao = ConnectionFactory.getConnection();
        ResultSet resposta = null;
        boolean ok = false;
        StringBuilder sql = new StringBuilder();
        
        try {            
            conexao = new ConnectionFactory().getConnection();
            sql.append("select * from CantinaEscola.responsavel");
            sql.append(" where nome_responsavel LIKE ? ");
            
            PreparedStatement stmt = conexao.prepareStatement(sql.toString());
            stmt.setString(1, ("'%" + respon.getNome() + "%'"));                     
            resposta = stmt.executeQuery();
            
            while (resposta.next()) {
                responsavel = new Responsavel();
                responsavel.setNome(resposta.getString("nome_responsavel"));
                responsavel.setCpf(resposta.getString("cpf_responsavel"));
                responsavel.setTelefone(resposta.getString("telefone_responsavel"));
                responsavel.setEmail(resposta.getString("email_responsavel"));
                responsaveis.add(responsavel);
            }
            
        } catch (SQLException error) {
            System.out.println(error.getMessage());
        } finally {
            if (conexao != null) {
                ConnectionFactory.FecharConexao(conexao, null, resposta);
            }
        }
        return (responsaveis);
    }

}
