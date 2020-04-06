package app.web.beans.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/home", "/heroes/delete", "/heroes/create", "/heroes/details"})
public class GuestAuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String isLogged = (String) ((HttpServletRequest) servletRequest).getSession().getAttribute("username");
        if (isLogged==null){
            ((HttpServletResponse) servletResponse).sendRedirect("/login");
        }else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
