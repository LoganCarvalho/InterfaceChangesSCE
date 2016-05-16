
package Model.Bean;

import Model.Dao.ResponsavelDAO;
import java.util.ArrayList;

public class Responsavel extends Usuario {
    
    private String cpf;
    private String email;
    private int id_Funcionario;

    public Responsavel(String cpf, String email, String nome, String cep, String telefone, String login, String senha, String tipo_usuario) {
        super(nome,telefone, login, senha, tipo_usuario);
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
    
       public int getId_Funcionario() {
        return id_Funcionario;
    }

    public void setId_Funcionario(int id_Funcionario) {
        this.id_Funcionario = id_Funcionario;
    }
    
     //modelo que deve ser seguido para fazer os outros métodos
     public int incluir(Responsavel respons) throws Exception {

          int resposta= 0;
         try {
              ResponsavelDAO responsavelDao = new ResponsavelDAO();
              resposta = responsavelDao.incluir(respons);
            
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
       
        return resposta;
    }
    
      public int excluir(Responsavel respons) throws Exception {

        ResponsavelDAO responsavel = new ResponsavelDAO();
        int resposta = responsavel.excluir(respons);
        return resposta;
    }
      
    public int update(Responsavel respons) throws Exception {

        ResponsavelDAO responsavel = new ResponsavelDAO();
        int resposta = responsavel.update(respons);
        return resposta;
    }
    
    public boolean consultarPeloCPF(Responsavel respons) throws Exception {

        ResponsavelDAO responsavel = new ResponsavelDAO();
        boolean resposta = responsavel.consultarPeloCPF(respons);
        return resposta;
    }
      
       public boolean consultar(Responsavel respons) throws Exception {

        ResponsavelDAO responsavel = new ResponsavelDAO();
        boolean resposta = responsavel.consultar(respons);
        return resposta;
    }
       
        public ArrayList<Responsavel> listarResponsavel() throws Exception {
       
        ResponsavelDAO responsavelDao = new ResponsavelDAO();
        ArrayList<Responsavel> resposta = responsavelDao.listarResponsavel();
        return resposta;
    }
}
