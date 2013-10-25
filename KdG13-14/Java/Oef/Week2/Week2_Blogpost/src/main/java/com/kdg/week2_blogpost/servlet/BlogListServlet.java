package com.kdg.week2_blogpost.servlet;

import com.kdg.week2_blogpost.model.Blog;
import java.io.IOException;
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
        Blog blog = (Blog) this.getServletContext().getAttribute("blog");
        request.setAttribute("posts", blog.getPosts().values());
        
        request.getRequestDispatcher("bloglist.jsp").forward(request, response);

    }
}
