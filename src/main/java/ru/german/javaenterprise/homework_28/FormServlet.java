package ru.german.javaenterprise.homework_28;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/form")
public class FormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/save-request.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (name == null || name.isBlank() ||
                username == null || username.isBlank() ||
                password == null || password.isBlank()) {
            resp.sendRedirect("/form");
            return;
        }
        req.setAttribute("name", name);
        req.setAttribute("username", username);
        req.setAttribute("password", password);
        req.getRequestDispatcher("/pages/success.jsp").forward(req, resp);

    }
}
