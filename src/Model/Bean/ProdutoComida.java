
package Model.Bean;

public class ProdutoComida extends Produto {
  
    private String ingredientes;

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
    
    
}
