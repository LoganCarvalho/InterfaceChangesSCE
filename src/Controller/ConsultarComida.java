
package Controller;

import Model.Bean.ProdutoComida;
import Model.Dao.ComidaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ConsultarComida", urlPatterns = {"/ConsultarComida"})
public class ConsultarComida extends HttpServlet {

     protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
       ProdutoComida comida = new ProdutoComida();
        boolean resposta = true;
        //Pegando parâmetros da tela
        comida.setNome(request.getParameter("txtComida"));
        
        try {
           resposta= comida.consultar(comida);
           
        } catch (Exception ex) {
            Logger.getLogger(CadastroResponsavel.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("comida", comida);
        RequestDispatcher rd = request.getRequestDispatcher("consultarComida.jsp");
        rd.include(request, response);
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
