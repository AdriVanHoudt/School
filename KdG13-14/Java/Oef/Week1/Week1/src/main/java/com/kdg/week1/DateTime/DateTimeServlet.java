/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdg.week1.DateTime;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 

/**
 *
 * @author Adri
 */
import javax.servlet.annotation.WebInitParam;
@WebServlet(name = "DateTimeServlet", urlPatterns = {"/DateTimeServlet"}, initParams={ @WebInitParam(name="dformat", value="yyyy/MM/dd HH:mm:ss")})
public class DateTimeServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DateTimeServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            DateFormat dateFormat = new SimpleDateFormat(getServletConfig().getInitParameter("dformat"));
            Date date = new Date();
            
            out.println("<h1>" + dateFormat.format(date) + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
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
