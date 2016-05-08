
package Model.Bean;

import Model.Dao.UsuarioDAO;

public class Usuario {
    
    private String nome;
    private String telefone;
    private String login;
    private String senha;
    private String ativo;
    private String tipo_usuario;
    
    public Usuario(String nome, String telefone, String login, String senha, String tipo_usuario) {
        this.nome = nome;      
        this.telefone = telefone;
        this.login = login;
        this.senha = senha;
        this.tipo_usuario = tipo_usuario;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public Usuario() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
   public boolean consultar(Usuario usuario) throws Exception {

        UsuarioDAO usuarioDao = new UsuarioDAO();
        boolean resposta = usuarioDao.consultar(usuario);
        return resposta;
    }
    
    
}
