
package Model.Bean;

import Model.Dao.ResponsavelDAO;

public class Responsavel extends Usuario {
    
    private String cpf;
    private String email;

    public Responsavel(String cpf, String email, String nome, String cep, String telefone, String login, String senha) {
        super(nome,telefone, login, senha);
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
    
      public int excluir() throws Exception {

        ResponsavelDAO responsavel = new ResponsavelDAO();
        int resposta = responsavel.excluir(this);
        return resposta;
    }
      
    public int update() throws Exception {

        ResponsavelDAO responsavel = new ResponsavelDAO();
        int resposta = responsavel.update(this);
        return resposta;
    }
      
       public boolean consultar(Responsavel respons) throws Exception {

        ResponsavelDAO responsavel = new ResponsavelDAO();
        boolean resposta = responsavel.consultar(respons);
        return resposta;
    }
}
