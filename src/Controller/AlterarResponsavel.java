
package Controller;

import Model.Bean.Responsavel;
import Model.Dao.ResponsavelDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AlterarResponsavel", urlPatterns = {"/AlterarResponsavel"})
public class AlterarResponsavel extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Responsavel respons = new Responsavel();
        respons.setNome(request.getParameter("nome"));
        respons.setTelefone(request.getParameter("telefone"));
        respons.setEmail(request.getParameter("email"));
        respons.setCpf(request.getParameter("cpf"));
        int resposta = 0;
        
        try {
           resposta= respons.update(respons);
           
        } catch (Exception ex) {
            Logger.getLogger(CadastroResponsavel.class.getName()).log(Level.SEVERE, null, ex);
        }
       request.setAttribute("responsavel", respons);
       RequestDispatcher rd = request.getRequestDispatcher("consultarResponsavel.jsp");
       rd.forward(request, response);
    }
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
