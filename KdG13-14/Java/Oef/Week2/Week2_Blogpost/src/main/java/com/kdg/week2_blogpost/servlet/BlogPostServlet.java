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
        User user = null;

        Blog blog = (Blog)cntxt.getAttribute("blog");

        if(!blog.userExists(request.getParameter("name"))){
            user = new User(request.getParameter("name"));
            blog.addPost(user, request.getParameter("jaar").toString() ,request.getParameter("specialiteit").toString(), request.getParameter("url").toString(), request.getParameter("omschrijving").toString());
        }else{
            user = blog.getUser(request.getParameter("name"));
            blog.addPost(user,request.getParameter("jaar").toString() ,request.getParameter("specialiteit").toString(), request.getParameter("url").toString(), request.getParameter("omschrijving").toString());   
        }
        
        response.sendRedirect("BlogListServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
