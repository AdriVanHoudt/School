/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
//        ServletContext cntxt = this.getServletContext();
//
//        Blog blog = (Blog) cntxt.getAttribute("blog");
//
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet NewServlet</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>" + ((User) request.getSession().getAttribute("user")).getUsername() + "</h1>");
//            out.println("<table border=1>");
//
//            Map posts = blog.getPosts();
//
//            Iterator it = posts.entrySet().iterator();
//
//            while (it.hasNext()) {
//                Map.Entry pairs = (Map.Entry) it.next();
//                Post post = (Post) pairs.getValue();
//
//                String colorcode = "#FFFFF";
//                if (!it.hasNext()) {
//                    colorcode = "#FFE473";
//                }
//
//                //posted by
//                out.println("<tr bgcolor=" + colorcode + ">");
//                out.println("<td>posted by</td>");
//                out.println("<td>" + post.getUser().getUsername() + "</td>");
//                out.println("</tr>");
//                //year
//                out.println("<tr bgcolor=" + colorcode + ">");
//                out.println("<td>jaar</td>");
//                out.println("<td>" + post.getYear() + "</td>");
//                out.println("</tr>");
//                //Specialization
//                out.println("<tr bgcolor=" + colorcode + ">");
//                out.println("<td>specializatie</td>");
//                out.println("<td>" + post.getSpecialization() + "</td>");
//                out.println("</tr>");
//                //description
//                out.println("<tr bgcolor=" + colorcode + ">");
//                out.println("<td>omschrijving</td>");
//                out.println("<td>" + post.getDescription() + "</td>");
//                out.println("</tr>");
//                //url
//                out.println("<tr bgcolor=" + colorcode + ">");
//                out.println("<td> url</td>");
//                out.println("<td><a href='http://" + post.getUrl() + "'>" + post.getUrl() + "</a></td>");
//                out.println("</tr>");
//
//            }
//
//            out.println("</table>");
//            //link to blogpost
//            out.println("<a href='blogpost.html'>Add a new post</a>");
//            out.println("<a href='LogOutServlet'>Log Out</a>");
//
//            out.println("</body>");
//            out.println("</html>");
//        }

    }
}
