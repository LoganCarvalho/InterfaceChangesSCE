
package Model.Bean;

import java.util.ArrayList;
import java.util.Date;

public class CompraProduto {
    
    private Date dataCompra;
    private ArrayList itens = new ArrayList<Item>();
    private Aluno aluno;

    public CompraProduto() {
    }

    public CompraProduto(Date dataCompra, Aluno aluno) {
        this.dataCompra = dataCompra;
        this.aluno = aluno;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public ArrayList getItens() {
        return itens;
    }

    public void setItens(ArrayList itens) {
        this.itens = itens;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    
    
}
