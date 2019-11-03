package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter({"/views/home.jsf","/views/create-hero.jsf", "/views/delete-hero.jsf", "/views/details-hero.jsf"})
public class LoggedInFilter implements Filter {

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    String isLogged = (String) ((HttpServletRequest) servletRequest).getSession().getAttribute("username");

    if (isLogged == null){
      ((HttpServletResponse) servletResponse).sendRedirect("/views/login.jsf");
      return;
    }

    filterChain.doFilter(servletRequest,servletResponse);
  }
}
