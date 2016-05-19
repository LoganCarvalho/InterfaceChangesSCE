
package Model.Bean;

import Model.Dao.EscolaDAO;

public class Escola {
    
    private String nomeEscola;
    private String enderecoEscola;
    private String telefoneEscola;
    private String emailEscola;
    private String cnpjEscola;
    private Funcionario funcionario;

    public Escola(String nomeEscola, String enderecoEscola, String telefoneEscola, String emailEscola, String cnpjEscola, Funcionario funcionario) {
        this.nomeEscola = nomeEscola;
        this.enderecoEscola = enderecoEscola;
        this.telefoneEscola = telefoneEscola;
        this.emailEscola = emailEscola;
        this.cnpjEscola = cnpjEscola;
        this.funcionario = funcionario;
    }

    public Escola() {
    }

    public String getNomeEscola() {
        return nomeEscola;
    }

    public void setNomeEscola(String nomeEscola) {
        this.nomeEscola = nomeEscola;
    }

    public String getEnderecoEscola() {
        return enderecoEscola;
    }

    public void setEnderecoEscola(String enderecoEscola) {
        this.enderecoEscola = enderecoEscola;
    }

    public String getTelefoneEscola() {
        return telefoneEscola;
    }

    public void setTelefoneEscola(String telefoneEscola) {
        this.telefoneEscola = telefoneEscola;
    }

    public String getEmailEscola() {
        return emailEscola;
    }

    public void setEmailEscola(String emailEscola) {
        this.emailEscola = emailEscola;
    }

    public String getCnpjEscola() {
        return cnpjEscola;
    }

    public void setCnpjEscola(String cnpjEscola) {
        this.cnpjEscola = cnpjEscola;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
     public int incluir(Escola escola) throws Exception {

          int resposta= 0;
         try {
              EscolaDAO escolaDao = new EscolaDAO();
              resposta = escolaDao.incluir(escola);
            
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
       
        return resposta;
    }
    
    
}
