package be.kdg.tagcustom.listeners;

import be.kdg.tagcustom.model.Films;
import be.kdg.tagcustom.model.Mandjes;
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