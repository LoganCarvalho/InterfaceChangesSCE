/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Bean.ProdutoComida;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author stephanie
 */
@WebServlet(name = "CadastroComida", urlPatterns = {"/CadastroComida"})
public class CadastroComida extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ProdutoComida produtoComida = new ProdutoComida();
        int resposta = 0;
        //Pegando parâmetros da tela
        produtoComida.setCodigo(request.getParameter("txtCodigoAlimento"));
        produtoComida.setNome(request.getParameter("txtNomeAlimento"));
        produtoComida.setIngredientes(request.getParameter("txtIngredientes"));
        produtoComida.setPreco(Double.valueOf(request.getParameter("txtPrecoAlimento")));
        produtoComida.setQuantidade(Integer.parseInt(request.getParameter("txtQntd")));
        try {
           resposta= produtoComida.incluir(produtoComida);
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

