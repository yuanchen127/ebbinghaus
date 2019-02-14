package org.ike.ebbinghaus.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "EncodingFilter", urlPatterns = "/*")
@Slf4j
public class EncodingFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
        log.info("===== EncodingFilter init =====");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        log.info("===== EncodingFilter doFilter =====");
        chain.doFilter(req, resp);
    }

    public void destroy() {
        log.info("===== EncodingFilter destroy =====");
    }
}
