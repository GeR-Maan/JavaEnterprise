package ru.german.javaenterprise.homework_28.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/greeting")
public class GreetingServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name"); // localhost:8080/greeting?name=John
        String message = "Hello %s!".formatted(name);

        List<String> names = List.of("John", "Jane", "Jack");

        String flag = req.getParameter("flag");

        req.setAttribute("flag", flag);
        req.setAttribute("message", message);
        req.setAttribute("names", names);

        getServletContext().getRequestDispatcher("/pages/greeting.jsp").forward(req, resp);
    }



}
