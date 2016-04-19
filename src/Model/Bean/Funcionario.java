
package Model.Bean;

public class Funcionario extends Usuario {
    
    private String matricula;

    public Funcionario(String matricula, String nome, String cep, String telefone, String login, String senha) {
        super(nome, telefone, login, senha);
        this.matricula = matricula;
    }

    public Funcionario() {
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    
}
