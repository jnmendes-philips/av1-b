/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import acesso.Compania;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import dao.DAO;

/**
 *
 * @author User
 */
@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("dao", new DAO(getServletContext().getRealPath("/")));
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
        request.setAttribute("companias", ((DAO) request.getAttribute("dao")).consultar());
        getServletContext().getRequestDispatcher("/listar.jsp").forward(request, response);
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
        if ("cadastro".equals(request.getParameter("parent"))) {
            Compania c = new Compania();
            c.setNome((String) request.getParameter("name"));
            c.setDominio((String) request.getParameter("domain"));
            c.setAno((String) request.getParameter("year"));
            c.setIndustria((String) request.getParameter("industry"));
            c.setTamanho((String) request.getParameter("size"));
            c.setLocalizacao((String) request.getParameter("locality"));
            c.setPais((String) request.getParameter("country"));
            c.setLinkedin((String) request.getParameter("linkedin"));
            c.setEmpregados_atual(validaInteger((String) request.getParameter("actual")));
            c.setEmpregados_total(validaInteger((String) request.getParameter("total")));
            ((DAO) request.getAttribute("dao")).incluir(c);
            request.setAttribute("msg", "Cadastro realizado com sucesso!");
            getServletContext().getRequestDispatcher("/mensagem.jsp").forward(request, response);
        } else if ("listar".equals(request.getParameter("parent"))) {
            request.setAttribute("companias", ((DAO) request.getAttribute("dao")).consultarComId(request.getParameter("id")));
            getServletContext().getRequestDispatcher("/listar.jsp").forward(request, response);
        }
    }
    
    private int validaInteger(String str) {
        return str == null || "".equals(str) ? 0 : Integer.parseInt(str);
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
