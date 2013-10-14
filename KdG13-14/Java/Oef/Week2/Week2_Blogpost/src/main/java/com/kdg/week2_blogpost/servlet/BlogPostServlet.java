package com.kdg.week2_blogpost.servlet;

import com.kdg.week2_blogpost.model.Blog;
import com.kdg.week2_blogpost.model.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.RequestDispatcher;

/**
 * User: Adri
 * Date: 30/09/13
 * Time: 14:39
 */
@WebServlet(name = "BlogPostServlet", urlPatterns = {"/BlogPostServlet"})
public class BlogPostServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext cntxt = getServletContext();

        Blog blog = (Blog)cntxt.getAttribute("blog");

       
        User user = (User) request.getSession().getAttribute("user");
        blog.addPost(user, request.getParameter("url").toString(), request.getParameter("omschrijving").toString());

        
        //RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/BlogListServlet");
        //dispatcher.forward(request, response);
        
        response.sendRedirect("BlogListServlet");
    }
}
