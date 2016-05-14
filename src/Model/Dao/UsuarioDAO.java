
package Model.Dao;

import Model.Bean.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    
    public boolean consultar(Usuario usuario) throws Exception {

        Connection conexao = ConnectionFactory.getConnection();
        ResultSet resposta = null;
        boolean ok = false;
        StringBuilder sql = new StringBuilder();

        try {
            sql.append("select * from CantinaEscola.usuario");
            sql.append(" where login_usuario = ? and senha_usuario = ?");
            PreparedStatement stmt = conexao.prepareStatement(sql.toString());
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha());

            resposta = stmt.executeQuery();
            while (resposta.next()) {
                usuario.setLogin(resposta.getString("login_usuario"));
                usuario.setSenha(resposta.getString("senha_usuario"));
                usuario.setTipo_usuario(resposta.getString("tipo_usuario"));

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
