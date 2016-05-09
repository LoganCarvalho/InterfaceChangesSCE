/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Bean.Usuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jcarvalho
 */

public class LoginPerfil extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Usuario usuario = new Usuario();
        
        //Pegando parâmetros da tela
        usuario.setLogin(request.getParameter("txtEmailLogin"));
        usuario.setSenha(request.getParameter("txtSenhaLogin"));
        
         try {
            usuario.consultar(usuario);
            if (usuario.getTipo_usuario().equals("F")){
                RequestDispatcher rd = request.getRequestDispatcher("FuncionarioIndex.jsp");
                request.getSession().setAttribute("login_usuario", usuario.getLogin());
                rd.include(request, response);
                               
            } else if (usuario.getTipo_usuario().equals("A")){
                RequestDispatcher rd = request.getRequestDispatcher("indexAluno.jsp");
                request.getSession().setAttribute("login_usuario", usuario.getLogin());
                rd.include(request, response);
            }   else{
                RequestDispatcher rd = request.getRequestDispatcher("indexResponsavel.jsp");
                request.getSession().setAttribute("login_usuario", usuario.getLogin());
                rd.include(request, response);
            }
        } catch (Exception ex) {
            Logger.getLogger(CadastroResponsavel.class.getName()).log(Level.SEVERE, null, ex);
        }
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


