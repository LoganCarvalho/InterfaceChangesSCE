package Model.Bean;

import Model.Dao.AlunoDAO;
import java.util.ArrayList;

public class Aluno extends Usuario {

    private int matricula;
    private String turno;
    private String turma;
    private double saldo;
    private ArrayList produtosBloqueados = new ArrayList<Produto>();
    private int idResponsavel;

    public Aluno() {
    }

    public Aluno(int matricula, String turno, String turma, double saldo, int idResponsavel, String nome, String cep, String telefone, String login, String senha, String tipo_usuario) {
        super(nome, telefone, login, senha, tipo_usuario);
        this.matricula = matricula;
        this.turno = turno;
        this.turma = turma;
        this.saldo = saldo;
        this.idResponsavel = idResponsavel;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
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

       public int getIdResponsavel() {
        return idResponsavel;
    }

    public void setIdResponsavel(int idResponsavel) {
        this.idResponsavel = idResponsavel;
    }

    public int calcularSaldoDepoisCompra(Aluno aluno) {
     //Quando eu chamar o comprar, ele vai pegar o valor da compra, vai 
        //subtrair do saldo atual(já tem que estar na tela de aluno) e vai dar um update com esse novo valor

        return 1;
    }
    
    
     public int depositarCredito(Aluno aluno) throws Exception {
         double  saldoAntigo;
         double  valorCredito = aluno.getSaldo();
         double novoSaldo;
         
         consultarSaldo(aluno);
         saldoAntigo = aluno.getSaldo();
         
         novoSaldo = saldoAntigo + valorCredito;
         aluno.setSaldo(novoSaldo);
         updateSaldo(aluno);
         
        return 1;
    }


    //modelo que deve ser seguido para fazer os outros métodos
    public int incluir(Aluno aluno) throws Exception {
        
        int resposta = 0;
        try {
            AlunoDAO alunoDao = new AlunoDAO();
            resposta = alunoDao.incluir(aluno);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return resposta;
    }

    public int update(Aluno aluno) throws Exception {

        AlunoDAO alunoDAO = new AlunoDAO();
        int resposta = alunoDAO.alterarAluno(aluno);
        return resposta;
    }
    
     public int updateSaldo(Aluno aluno) throws Exception {

        AlunoDAO alunoDAO = new AlunoDAO();
        int resposta = alunoDAO.update(aluno);
        return resposta;
    }

    public int excluir(Aluno aluno) throws Exception {

        AlunoDAO alunoDao = new AlunoDAO();
        int resposta = alunoDao.excluir(aluno);
        return resposta;
    }

    public boolean consultarSaldo(Aluno aluno) throws Exception {

        AlunoDAO alunoDao = new AlunoDAO();
        boolean resposta = alunoDao.consultarSaldo(aluno);
        return resposta;
    }
    
        public boolean consultarSaldoAluno(Aluno aluno, Usuario usuario) throws Exception {

        AlunoDAO alunoDao = new AlunoDAO();
        boolean resposta = alunoDao.consultarSaldoAluno(aluno, usuario);
        return resposta;
    }
    
    public boolean consultar(Aluno aluno) throws Exception {

        AlunoDAO alunoDao = new AlunoDAO();
        boolean resposta = alunoDao.consultar(aluno);
        return resposta;
    }

}
