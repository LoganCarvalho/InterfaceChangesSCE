
package Model.Bean;

import Model.Dao.BebidaDAO;

public class ProdutoBebida extends Produto {
    
    private String fornecedor;

    public ProdutoBebida(String fornecedor, String codigo, String nome, String preco, int quantidade, boolean disponivel) {
        super(codigo, nome, preco, quantidade, disponivel);
        this.fornecedor = fornecedor;
    }
    
    public ProdutoBebida(){
    
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    
 public int incluir(ProdutoBebida produtoBebida) throws Exception {

          int resposta= 0;
         try {
              BebidaDAO bebidaDao = new BebidaDAO();
              resposta = bebidaDao.incluir(produtoBebida);
            
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
       
        return resposta;
    }
    
      public int excluir() throws Exception {

        BebidaDAO bebidaDao = new BebidaDAO();
        int resposta = bebidaDao.excluir(this);
        return resposta;
    }
      
    public int update() throws Exception {

        BebidaDAO bebidaDao = new BebidaDAO();
        int resposta = bebidaDao.update(this);
        return resposta;
    }
      
     /*  public boolean consultar(ProdutoBebida produtoBebida) throws Exception {

        BebidaDAO bebidaDao = new BebidaDAO();
        boolean resposta = bebidaDao.consultar(produtoBebida);
        return resposta;
    }*/
    
    
}

