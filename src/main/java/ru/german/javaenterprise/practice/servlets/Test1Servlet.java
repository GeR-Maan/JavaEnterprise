package ru.german.javaenterprise.practice.servlets;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/test1",name = "test1")
public class Test1Servlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = getServletContext();
        context.setAttribute("name", "German");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Test1 Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet Test1 Servlet</h1>");
        out.println("</body>");
        out.println("</html>");

    }
}
