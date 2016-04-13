
package Model.Bean;

public class Usuario {
    
    private String nome;
    private String cep;
    private String telefone;
    private String login;
    private String senha;

    public Usuario(String nome, String cep, String telefone, String login, String senha) {
        this.nome = nome;
        this.cep = cep;
        this.telefone = telefone;
        this.login = login;
        this.senha = senha;
    }

    public Usuario() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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
    
    
    
}
