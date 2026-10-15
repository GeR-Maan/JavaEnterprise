package ru.german.javaenterprise.homework_28.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.german.javaenterprise.homework_28.model.Account;
import ru.german.javaenterprise.homework_28.model.Post;
import ru.german.javaenterprise.homework_28.storage.InMemoryPostStorage;

import java.io.IOException;

@WebServlet("/post/create")
public class CreatePostServlet extends HttpServlet {

    private final InMemoryPostStorage postStorage = new InMemoryPostStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        String url = req.getParameter("imageUrl");

        HttpSession session = req.getSession();
        Account account = (Account) session.getAttribute("account");

        postStorage.save(new Post(title, content, account, url));

        resp.sendRedirect("/");
    }
}
