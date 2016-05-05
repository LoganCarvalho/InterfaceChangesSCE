
package Model.Bean;

import Model.Dao.AlunoDAO;
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
    
        //modelo que deve ser seguido para fazer os outros métodos
     public int incluir(Aluno aluno) throws Exception {

          int resposta= 0;
         try {
              AlunoDAO alunoDao = new AlunoDAO();
              resposta = alunoDao.incluir(aluno);
            
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
       
        return resposta;
    }
    
      public int excluir() throws Exception {

        AlunoDAO aluno = new AlunoDAO();
        int resposta = aluno.excluir(this);
        return resposta;
    }
      
       public boolean consultar(Aluno aluno) throws Exception {

        AlunoDAO alunoDao = new AlunoDAO();
        boolean resposta = alunoDao.consultar(aluno);
        return resposta;
    }
    
        
}
