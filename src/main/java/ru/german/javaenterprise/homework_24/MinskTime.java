package ru.german.javaenterprise.homework_24;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


@WebServlet("/minsk")
public class MinskTime extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ZoneId zone = ZoneId.of("Europe/Minsk");                  // 1. часовой пояс города
        ZonedDateTime now = ZonedDateTime.now(zone);               // 2. текущее время в этом поясе
        String text = now.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")); // 3. в красивую строку

        resp.setContentType("text/html");
        resp.getWriter().println("<h1> Minsk time: " + text + "</h1>");



    }
}



/*
*  Задача *:
        Дополнительно реализовать следующий функционал: если с консоли введено значение 1
        - распарсить документ с помощью SAX, если с консоли введено значение 2 - распарсить
        документ с помощью DOM*/
/*Задача 1:
Задача 2:
/*Написать приложение, которое при запуске будет сообщать в консоль что оно
работает. На любой запрос в консоли должна отображаться запись со временем этого
запроса.
Создать 2 эндпоинта:
/book - который будет скачивать с сервера клиенту любую книгу.
/load-book - который позволит загружать свои книги на сервер.*/

