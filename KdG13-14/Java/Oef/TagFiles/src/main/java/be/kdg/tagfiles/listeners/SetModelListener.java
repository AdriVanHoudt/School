package be.kdg.tagfiles.listeners;

import be.kdg.tagfiles.model.Films;
import be.kdg.tagfiles.model.Mandjes;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class SetModelListener implements ServletContextListener
{
    @Override
    public void contextInitialized(ServletContextEvent event)
    {
        ServletContext servletContext = event.getServletContext();
        servletContext.setAttribute("films", new Films());
        servletContext.setAttribute("mandjes", new Mandjes());
    }

    @Override
    public void contextDestroyed(ServletContextEvent event)
    {
    }
}
