
package Model.Bean;

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
    
    
}
