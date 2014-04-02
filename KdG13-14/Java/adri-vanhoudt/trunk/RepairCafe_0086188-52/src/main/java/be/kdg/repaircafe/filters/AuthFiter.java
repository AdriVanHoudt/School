package be.kdg.repaircafe.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Adri
 */
@WebFilter(filterName = "AuthFiter", urlPatterns = {"/profile.xhtml", "/newrepair.xhtml", "/searchrepairs.xhtml", "/clientdash.xhtml"})
public class AuthFiter implements Filter {

    public AuthFiter() {
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        
        if( session == null || session.getAttribute("username") == null)
        {
            // not logged in
            // redirect to log in
            res.sendRedirect(req.getContextPath() + "/index.xhtml");
        } 
        else
        {
            chain.doFilter(req, res);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // no init params needed
    }

    @Override
    public void destroy() {
        // nothing to destroy
    }
}