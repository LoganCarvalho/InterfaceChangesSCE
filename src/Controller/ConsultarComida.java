
package Controller;

import Model.Bean.ProdutoComida;
import Model.Dao.ComidaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ConsultarComida", urlPatterns = {"/ConsultarComida"})
public class ConsultarComida extends HttpServlet {

     protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        ProdutoComida produtoComida = new ProdutoComida();        
        //Pegando parâmetros da tela        
        produtoComida.setNome(request.getParameter("sellComida"));
        ComidaDAO daoComida = new ComidaDAO();
        List linhasList = daoComida.getComida(); 
        request.getSession().setAttribute("nome_comida", linhasList);
     
     }    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
             processRequest(request, response);
         } catch (Exception ex) {
             Logger.getLogger(ConsultarComida.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
