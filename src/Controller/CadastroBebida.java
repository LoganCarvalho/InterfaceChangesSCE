
package Controller;

import Model.Bean.ProdutoBebida;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CadastroBebida", urlPatterns = {"/CadastroBebida"})
public class CadastroBebida extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ProdutoBebida produtoBebida = new ProdutoBebida();
        int resposta = 0;
        //Pegando parâmetros da tela
        produtoBebida.setCodigo(request.getParameter("txtCodigoBebida"));
        produtoBebida.setNome(request.getParameter("txtNomeBebida"));
        produtoBebida.setFornecedor(request.getParameter("txtFornecedor"));
        produtoBebida.setPreco(request.getParameter("txtPrecoBebida"));
        produtoBebida.setQuantidade(Integer.parseInt(request.getParameter("txtQntdBebida")));
        try {
           resposta= produtoBebida.incluir(produtoBebida);
        } catch (Exception ex) {

            Logger.getLogger(CadastroResponsavel.class.getName()).log(Level.SEVERE, null, ex);
        }
         //Verificar uma forma de exibir uma mesnagem depois que a inserção ocorrer com sucesso.
     
        RequestDispatcher rd = request.getRequestDispatcher("sucesso.jsp");
        rd.include(request, response);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
} 

