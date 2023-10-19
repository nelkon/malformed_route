package org.example;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IPFilter implements Filter {
    private String allowedIP = "192.168.5.130";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // You can initialize the allowed IP address here if needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String remoteIP = httpRequest.getRemoteAddr();

        if (!remoteIP.equals(allowedIP)) {
            // Redirect to the specified URL
            String redirectURL = "https://localhost:9443/devportal";
            httpResponse.sendRedirect(redirectURL);
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        // Clean up resources if needed
    }
}

