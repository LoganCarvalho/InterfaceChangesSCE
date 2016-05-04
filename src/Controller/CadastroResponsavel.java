/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author jcarvalho
 */
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
     
        RequestDispatcher rd = request.getRequestDispatcher("***.jsp");
        rd.include(request, response);
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
