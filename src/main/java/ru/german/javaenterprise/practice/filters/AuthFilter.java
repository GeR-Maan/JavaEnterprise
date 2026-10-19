package ru.german.javaenterprise.practice.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(urlPatterns = "/admin/*")
public class AuthFilter  extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        String role = req.getParameter("role");
        if (role.equals("admin")) {
            chain.doFilter(req, res);
        }else {
            res.sendError(HttpServletResponse.SC_FORBIDDEN);
        }

    }
}
