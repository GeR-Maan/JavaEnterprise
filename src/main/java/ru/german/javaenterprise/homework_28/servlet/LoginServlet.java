package ru.german.javaenterprise.homework_28.servlet;

import by.tms.lesson2842onl.model.Account;
import by.tms.lesson2842onl.storage.InMemoryAccountStorage;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private final InMemoryAccountStorage storage = new InMemoryAccountStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Optional<Account> byUsername = storage.findByUsername(username);
        if (byUsername.isPresent()) {
            Account account = byUsername.get();
            if (account.getPassword().equals(password)) {
                req.getSession().setAttribute("account", account);
                resp.sendRedirect("/");
                return;
            }
        }

        req.setAttribute("message", "Invalid username or password");
        getServletContext().getRequestDispatcher("/pages/login.jsp").forward(req, resp);
    }
}
