
package Model.Bean;

public class Responsavel extends Usuario {
    
    private String cpf;
    private String email;

    public Responsavel(String cpf, String email, String nome, String cep, String telefone, String login, String senha) {
        super(nome, cep, telefone, login, senha);
        this.cpf = cpf;
        this.email = email;
    }

    public Responsavel() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
