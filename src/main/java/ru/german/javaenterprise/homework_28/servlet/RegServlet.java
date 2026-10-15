package ru.german.javaenterprise.homework_28.servlet;

import by.tms.lesson2842onl.model.Account;
import by.tms.lesson2842onl.storage.InMemoryAccountStorage;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/reg")
public class RegServlet extends HttpServlet {

    private final InMemoryAccountStorage storage = new InMemoryAccountStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/reg.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Account account = new Account(name, username, password);
        storage.save(account);

        resp.sendRedirect("/login");
    }
}
