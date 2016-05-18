
package Model.Bean;

import Model.Dao.ComidaDAO;
import java.util.Date;
import java.util.List;

public class ProdutoComida extends Produto {
  
    private String ingredientes;
    private Date dataCompra;
 

    public ProdutoComida(){
    
    }

    public ProdutoComida(String ingredientes, String codigo, String nome, double preco, int quantidade, boolean disponivel) {
        super(codigo, nome, preco, quantidade, disponivel);
        this.ingredientes = ingredientes;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }
    
     public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }
    
    
     public int incluir(ProdutoComida produtoComida) throws Exception {

          int resposta= 0;
         try {
              ComidaDAO comidaDao = new ComidaDAO();
              resposta = comidaDao.incluir(produtoComida);
            
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
       
        return resposta;
    }
    
      public int excluir(ProdutoComida produtoComida) throws Exception {

        ComidaDAO ComidaDao = new ComidaDAO();
        int resposta = ComidaDao.excluir(produtoComida);
        return resposta;
    }
      
    public int update(ProdutoComida produtoComida) throws Exception {

        ComidaDAO ComidaDao = new ComidaDAO();
        int resposta = ComidaDao.update(produtoComida);
        return resposta;
    }
      
      public boolean consultar(ProdutoComida produtoComida) throws Exception {

        ComidaDAO comidaDao = new ComidaDAO();
        boolean resposta = comidaDao.consultar(produtoComida);
        return resposta;
    }
      
      public boolean consultarComidasDisponiveis(ProdutoComida produtoComida) throws Exception {

        ComidaDAO comidaDao = new ComidaDAO();
        boolean resposta = comidaDao.consultarComidasDisponiveis(produtoComida);
        return resposta;
    }
    
    public List<ProdutoComida> getComida() throws Exception {
       
        ComidaDAO ComidaDao = new ComidaDAO();
        List<ProdutoComida> resposta = ComidaDao.getComida();
        return resposta;
    }
    
    
}
