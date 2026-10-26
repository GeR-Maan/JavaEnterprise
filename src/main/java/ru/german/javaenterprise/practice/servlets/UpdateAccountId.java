package ru.german.javaenterprise.practice.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.german.javaenterprise.practice.models.Account;
import ru.german.javaenterprise.practice.storage.JdbcAccountStorage;

import java.io.IOException;


@WebServlet("/account/update")
public class UpdateAccountId extends HttpServlet {

    private final JdbcAccountStorage storage = new JdbcAccountStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Account account = (Account) req.getSession().getAttribute("account");

        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");


        storage.updateById(account.getId(), name, username, password);
        account.setName(name);
        account.setUsername(username);
        account.setPassword(password);

        resp.sendRedirect("/home");


    }
}
