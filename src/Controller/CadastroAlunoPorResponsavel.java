
package Controller;

import Model.Bean.Aluno;
import Model.Bean.Responsavel;
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
        Responsavel respons = new Responsavel();
        int resposta = 0;
        boolean respostaResponsavel = false;
        //Pegando parâmetros da tela. Avaliar necessidade de capturar mais campos
        aluno.setNome(request.getParameter("txtNomeAluno"));
       // aluno.setMatricula(Integer.parseInt(request.getParameter("txtMatricula"))); //a servlet não funciona por causa dessa converã para inteiro
        aluno.setTurma(request.getParameter("txtTurma"));
        aluno.setTurno(request.getParameter("txtTurno"));
        aluno.setLogin(request.getParameter("txtLoginAluno"));
        aluno.setSenha(request.getParameter("txtSenhaAluno"));
        respons.setCpf(request.getParameter("txtCpfResponsavel"));
        
        try {
            //faz uma busca em reponsável pelo CPF
            respostaResponsavel = respons.consultarPeloCPF(respons);
            aluno.setIdResponsavel(respons.getIdResponsavel());
            resposta= aluno.incluir(aluno);
        } catch (Exception ex) {
            Logger.getLogger(CadastroAlunoPorResponsavel.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (respostaResponsavel!= false){
                   RequestDispatcher rd = request.getRequestDispatcher("sucesso.jsp");
            rd.include(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.include(request, response);
        }
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
