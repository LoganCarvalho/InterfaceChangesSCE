
package Model.Bean;

public class Funcionario extends Usuario {
    
    private String matricula;

    public Funcionario(String matricula, String nome, String cep, String telefone, String login, String senha, String tipo_usuario) {
        super(nome, telefone, login, senha, tipo_usuario);
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
