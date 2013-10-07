package com.kdg.week2_blogpost.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import com.kdg.week2_blogpost.model.Blog;


/**
 * User: Adri
 * Date: 30/09/13
 * Time: 14:49
 */
public class ServletContextListener implements javax.servlet.ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext cntxt = servletContextEvent.getServletContext();

        cntxt.setAttribute("blog", new Blog());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Destroyed");
    }
}
