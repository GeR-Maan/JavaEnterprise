package ru.german.javaenterprise.homework_25;


import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


@WebListener
public class ApplicationListener implements ServletContextListener{



    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ZonedDateTime now = ZonedDateTime.now();
        String text = now.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
        System.out.println("Приложение запущено: " + text);


    }

    @Override
    synchronized public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Приложение остановлено");
    }


}
