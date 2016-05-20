
package Controller;

import Model.Bean.ProdutoBebida;
import Model.Bean.ProdutoComida;
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

@WebServlet(name = "AlterarBebida", urlPatterns = {"/AlterarBebida"})
public class AlterarBebida extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ProdutoBebida bebida = new ProdutoBebida();
        bebida.setCodigo(request.getParameter("codigo"));
        bebida.setNome(request.getParameter("nome"));
        bebida.setPreco(Double.parseDouble(request.getParameter("preco")));
        bebida.setFornecedor(request.getParameter("fornecedor"));
        bebida.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));

        int resposta = 0;
        
        try {
           resposta= bebida.update(bebida);
           
        } catch (Exception ex) {
            Logger.getLogger(AlterarBebida.class.getName()).log(Level.SEVERE, null, ex);
        }
       request.setAttribute("bebida", bebida);
       RequestDispatcher rd = request.getRequestDispatcher("consultarBebida.jsp");
       rd.forward(request, response);
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
