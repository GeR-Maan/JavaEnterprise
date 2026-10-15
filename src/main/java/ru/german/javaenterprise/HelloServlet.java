package ru.german.javaenterprise;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        if (name == null || name.isBlank()) {
            name = "Гость";
        }
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = resp.getWriter();
        writer.println("<h1> Привет, " + name + "</h1>");
        System.out.println(req.getRequestURI());


    }


}