
package Model.Bean;

import Model.Dao.BebidaDAO;

public class ProdutoBebida extends Produto {
    
    private String fornecedor;

    public ProdutoBebida(String fornecedor, String codigo, String nome, double preco, int quantidade, boolean disponivel) {
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
    
      public int excluir(ProdutoBebida produtoBebida) throws Exception {

        BebidaDAO bebidaDao = new BebidaDAO();
        int resposta = bebidaDao.excluir(produtoBebida);
        return resposta;
    }
      
    public int update(ProdutoBebida produtoBebida) throws Exception {

        BebidaDAO bebidaDao = new BebidaDAO();
        int resposta = bebidaDao.update(produtoBebida);
        return resposta;
    }
      
      public boolean consultar(ProdutoBebida produtoBebida) throws Exception {

        BebidaDAO bebidaDao = new BebidaDAO();
        boolean resposta = bebidaDao.consultar(produtoBebida);
        return resposta;
    }
    
    
}

