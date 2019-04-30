package team06.platform.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.regex.Pattern;

public class authenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.printf("[%-23s] Init Filter\n", new Timestamp(new Date().getTime()));
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        HttpSession session = servletRequest.getSession();

        // Get request URI
        String path = servletRequest.getRequestURI();

        // Get userId from session
        String userId = (String) session.getAttribute("userid");

        // Whitelist
        String pattern = ".\\.jpg";
        if(path.equals("/")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }else if(path.equals("/console")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }else if(path.equals("/login.jsp")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }else if(path.equals("/login")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }else if(path.equals("/logout")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }else if(path.equals("/guide")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }else if(Pattern.matches(pattern, path)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        if (userId == null || "".equals(userId)) {
            servletResponse.sendRedirect("/login.jsp");
        } else {
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
