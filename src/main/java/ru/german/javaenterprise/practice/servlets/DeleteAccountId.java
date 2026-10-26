package ru.german.javaenterprise.practice.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.german.javaenterprise.practice.models.Account;
import ru.german.javaenterprise.practice.storage.JdbcAccountStorage;

import java.io.IOException;

@WebServlet("/account/delete")
public class DeleteAccountId  extends HttpServlet {

    private final JdbcAccountStorage jdbcAccountStorage = new JdbcAccountStorage();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Account account = (Account) req.getSession().getAttribute("account");
        jdbcAccountStorage.deleteById(account.getId());
        resp.sendRedirect("/home");

    }
}
