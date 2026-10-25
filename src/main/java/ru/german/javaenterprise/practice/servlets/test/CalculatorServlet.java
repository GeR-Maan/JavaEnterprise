package ru.german.javaenterprise.practice.servlets.test;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/calc") // /calc?num1=10&num2=5&type=sum
public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer num1 = parseIntOrNull(req.getParameter("num1"));
        Integer num2 = parseIntOrNull(req.getParameter("num2"));
        String type = req.getParameter("type");

        if (num1 == null || num2 == null || type == null || type.isBlank()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST,
                    "Нужны параметры num1, num2 (целые числа) и type");
            return;
        }

        int result;

        switch (type){
            case "sum" -> result = num1 + num2;
            case "sub" -> result = num1 - num2;
            case "mul" -> result = num1 * num2;
            case "div" -> {
                if (num2 == 0){
                    resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
                    return;
                }
                result = num1/num2;
            }
            default -> {resp.sendError(HttpServletResponse.SC_BAD_REQUEST,
                    "Неизвестная операция: " + type);
                return;
            }
        }

        resp.setContentType("text/plain;charset=UTF-8");
        resp.getWriter().println("Результат: " + result);



    }


    private Integer parseIntOrNull(String num){

        if (num == null) return null;
        try {
            return Integer.parseInt(num.trim());
        } catch (NumberFormatException e) {
            return null;
        }

    }


}
