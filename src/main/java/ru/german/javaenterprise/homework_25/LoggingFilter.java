package ru.german.javaenterprise.homework_25;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@WebFilter("/*")
public class LoggingFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        String requestURI = req.getRequestURI();
        String method = req.getMethod();

        ZonedDateTime now = ZonedDateTime.now();
        String text = now.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
        System.out.println("Пришёл запрос на адрес: " + requestURI + ". Метод: " + method + ". Время: " + text);
        chain.doFilter(req, res);


    }
}
