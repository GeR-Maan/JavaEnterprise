package ru.german.javaenterprise.homework_24;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/age")
public class Adult extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer age = parseInteer(req.getParameter("value"));

        if (age == null || age < 0 || age > 150) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Возраст не указан или указан некорректно");
            return;
        }

        String message = adultOrNot(age);
        resp.setContentType("text/html");
        resp.getWriter().println(message);


    }


    private Integer parseInteer(String age){
        try {
            return Integer.parseInt(age);
        }catch (NumberFormatException e){
            return null;
        }
    }

    private String adultOrNot(Integer age){

        String message;

        if (age > 18 || age == 18){
            message = "Вы являетесь совершеннолетним";
        }else {
            message = "Вы являетесь несовершеннолетним";
        }
        return message;
    }

}
