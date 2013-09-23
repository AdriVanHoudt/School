package com.kdg.week1.simpleservlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Adri
 */
@WebServlet("/SimpleServlet")
public class SilmpleServlet extends HttpServlet {

    private int numberOfAccesses;

    @Override
    public void init(ServletConfig serverConfig) throws ServletException {
        numberOfAccesses = 0;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        numberOfAccesses++;
        String result = "<html><head><title>My Servlet</title></head><body>";
        result += "This page has been accessed " + numberOfAccesses + " times...";

        if (numberOfAccesses == 5) {
            result += "ADRI OWND!";
        }

        result += "</body></html>";
        out.println(result);
    }
}
