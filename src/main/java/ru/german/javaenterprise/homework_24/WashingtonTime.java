package ru.german.javaenterprise.homework_24;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


public class WashingtonTime  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ZoneId zone = ZoneId.of("America/New_York");
        ZonedDateTime now = ZonedDateTime.now(zone);
        String text = now.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));

        resp.setContentType("text/html");
        resp.getWriter().println("<h1> Minsk time: " + text + "</h1>");


    }
}

