/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdg.week1.keuze;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Adri
 */
@WebServlet(name = "KeuzeServlet", urlPatterns = {"/KeuzeServlet"})
public class KeuzeServlet extends HttpServlet {

  
    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet KeuzeServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Invoer ter controle </h1>");
            out.println("<br/>");
            out.println(request.getParameter("naam"));
            out.println(request.getParameter("jaar"));
            out.println(request.getParameter("spec"));
            out.println("</body>");
            out.println("</html>");
        }
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
