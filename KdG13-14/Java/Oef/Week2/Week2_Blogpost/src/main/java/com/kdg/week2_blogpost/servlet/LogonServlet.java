package com.kdg.week2_blogpost.servlet;

import com.kdg.week2_blogpost.model.User;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Adri
 */
@WebServlet(name = "LogonServlet", urlPatterns = {"/LogonServlet"})
public class LogonServlet extends HttpServlet {
    
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User(request.getParameter("name"), request.getParameter("specialiteit"), request.getParameter("jaar"));
        
        request.getSession().setAttribute("user", user);
        
        response.sendRedirect("blogpost.html");
    }

}
