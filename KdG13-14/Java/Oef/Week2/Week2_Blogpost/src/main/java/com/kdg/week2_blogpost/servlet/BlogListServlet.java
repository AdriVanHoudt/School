/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdg.week2_blogpost.servlet;

import com.kdg.week2_blogpost.model.Blog;
import com.kdg.week2_blogpost.model.Post;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Adri
 */
@WebServlet(name = "BlogListServlet", urlPatterns = {"/BlogListServlet"})
public class BlogListServlet extends HttpServlet {
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext cntxt = this.getServletContext();
        
        Blog blog = (Blog)cntxt.getAttribute("blog");
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<table>");
            
            Map posts = blog.getPosts();
            while(it.hasNext()){
                Post post = (Post)posts.get(i);
                //posted by
                out.println("<tr>");
                out.println("<td>posted b²y</td>");
                out.println("<td>" + post.getUser().getUsername() + "</td>");               
                out.println("</tr>");
                //year
                out.println("<tr>");
                out.println("<td>jaar</td>");
                out.println("<td>" + post.getYear() + "</td>");               
                out.println("</tr>");
                //Specialization
                out.println("<tr>");
                out.println("<td>jaar</td>");
                out.println("<td>" + post.getSpecialization() + "</td>");               
                out.println("</tr>");
                //description
                out.println("<tr>");
                out.println("<td>jaar</td>");
                out.println("<td>" + post.getDescription()+ "</td>");               
                out.println("</tr>");
                //url
                out.print("<tr>");
                out.println("<td>jaar</td>");
                out.print("<td>" + post.getUrl() + "</td>");               
                out.print("</tr>");
                
            }
            out.println("</table>");
            //link to blogpost
            out.println("<a href='blogpost.html'>Add a new post</a>");
            
            out.println("</body>");
            out.println("</html>");
        } 
        
    } 
}
