
package Model.Bean;

import java.util.ArrayList;

public class Aluno extends Usuario {
    
    private String matricula;
    private String turno;
    private String turma;
    private double saldo;
    private ArrayList produtosBloqueados =  new ArrayList<Produto>();
    private Responsavel responsavel;

    public Aluno() {
    }

    public Aluno(String matricula, String turno, String turma, double saldo, Responsavel responsavel, String nome, String cep, String telefone, String login, String senha) {
        super(nome, telefone, login, senha);
        this.matricula = matricula;
        this.turno = turno;
        this.turma = turma;
        this.saldo = saldo;
        this.responsavel = responsavel;
    }
    
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public ArrayList getProdutosBloqueados() {
        return produtosBloqueados;
    }

    public void setProdutosBloqueados(ArrayList produtosBloqueados) {
        this.produtosBloqueados = produtosBloqueados;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }
    
        
}
