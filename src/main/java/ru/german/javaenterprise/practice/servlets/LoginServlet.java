package ru.german.javaenterprise.practice.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.german.javaenterprise.practice.models.Account;
import ru.german.javaenterprise.practice.storage.JdbcAccountStorage;

import java.io.IOException;
import java.util.Optional;


@WebServlet("/account/login")
public class LoginServlet extends HttpServlet {

    private final JdbcAccountStorage storage = new JdbcAccountStorage();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/acc-login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Optional<Account> byUsername = storage.findByUsername(username);
        if (byUsername.isPresent()) {
            Account account = byUsername.get();
            if (password.equals(account.getPassword())) {
                req.getSession().setAttribute("account", account);
                resp.sendRedirect("/home");
            }
        }
        else {
            resp.sendRedirect("/account/login");
        }

    }
}
