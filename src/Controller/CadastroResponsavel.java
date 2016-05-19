
package Controller;

import Model.Bean.Responsavel;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CadastroResponsavel extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        response.setContentType("text/html;charset=UTF-8");
        Responsavel respons = new Responsavel();
        int resposta = 0;
        //Pegando parâmetros da tela
        respons.setNome(request.getParameter("txtNomeResponsavel"));
        respons.setEmail(request.getParameter("txtEmailResponsavel"));
        respons.setCpf(request.getParameter("txtCpfResponsavel"));
        respons.setTelefone(request.getParameter("txtTelResponsavel"));
        respons.setLogin(request.getParameter("txtLoginResponsavel"));
        respons.setSenha(request.getParameter("txtSenhaResponsavel"));
        try {
           resposta= respons.incluir(respons);
        } catch (Exception ex) {
            Logger.getLogger(CadastroResponsavel.class.getName()).log(Level.SEVERE, null, ex);
        }
         //Verificar uma forma de exibir uma mesnagem depois que a inserção ocorrer com sucesso.
     if(resposta != 0){ 
        RequestDispatcher rd = request.getRequestDispatcher("sucesso.jsp");
        rd.include(request, response);      
     } else {
        RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
        rd.include(request, response);
     }
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
