package ru.german.javaenterprise.practice.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.german.javaenterprise.practice.models.Account;
import ru.german.javaenterprise.practice.storage.JdbcAccountStorage;

import java.io.IOException;


@WebServlet("/account/reg")
public class AccountRegServlet extends HttpServlet {

    private final JdbcAccountStorage jdbcAccountStorage = new JdbcAccountStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/acc-reg.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Account account = new Account();
        account.setName(name);
        account.setUsername(username);
        account.setPassword(password);

        Profile profile = new Profile();
        profile.setEmail(email);

        account.setProfile(profile);

        jdbcAccountStorage.save(account);

        resp.sendRedirect("/home");

    }
}
