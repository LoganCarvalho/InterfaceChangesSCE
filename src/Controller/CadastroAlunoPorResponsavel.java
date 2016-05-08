
package Controller;

import Model.Bean.Aluno;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CadastroAlunoPorResponsavel extends HttpServlet {
   
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");         
        Aluno aluno = new Aluno();
        int resposta = 0;
        //Pegando parâmetros da tela. Avaliar necessidade de capturar mais campos
        aluno.setNome(request.getParameter("txtNomeAluno"));
        aluno.setMatricula(request.getParameter("txtMatricula"));
        aluno.setTurma(request.getParameter("txtTurma"));
        aluno.setTurno(request.getParameter("txtTurno"));
        aluno.setLogin(request.getParameter("txtLoginAluno"));
        aluno.setSenha(request.getParameter("txtSenhaAluno"));
        
        try {
            resposta= aluno.incluir(aluno);
        } catch (Exception ex) {
            Logger.getLogger(CadastroAlunoPorResponsavel.class.getName()).log(Level.SEVERE, null, ex);
        }
        RequestDispatcher rd = request.getRequestDispatcher("sucesso.jsp");
        rd.include(request, response);
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
