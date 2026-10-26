package ru.german.javaenterprise.practice.storage;

import ru.german.javaenterprise.practice.models.Account;
import ru.german.javaenterprise.practice.servlets.Profile;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Всё начинаем снизу вверх. Сначала Схему БД, потом модели, потом Jdbc, потом уже сервлеты страниц и сами страницы
// ТУТ для подключения драйвера надо нам ещё вручную зарегать драйвер. Это надо только в джава сервлетах. С помощью слушателя
// При инициализации контекста Class.forName("org.postgresql.Driver");


public class JdbcAccountStorage {

    public void save(Account account) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres", "8948");
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO profiles VALUES (default, ?) RETURNING id");
            preparedStatement.setString(1, account.getProfile().getEmail());
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            long pId = resultSet.getLong("id");



            PreparedStatement preparedStatement2 = connection.prepareStatement("INSERT INTO accounts VALUES (default, ?, ?,?,?)");
            preparedStatement2.setString(1,account.getName());
            preparedStatement2.setString(2,account.getUsername());
            preparedStatement2.setString(3,account.getPassword());
            preparedStatement2.setLong(4,pId);
            preparedStatement2.executeUpdate();
            connection.commit();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<Account> findByUsername(String username) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres", "8948");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM accounts JOIN profiles ON accounts.profile_id = profiles.id WHERE username = ?");
            preparedStatement.setString(1,username);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                Account account = new Account();
                account.setId(resultSet.getLong("id"));
                account.setName(resultSet.getString("name"));
                account.setUsername(resultSet.getString("username"));
                account.setPassword(resultSet.getString("password"));

                Profile profile = new Profile();
                profile.setId(resultSet.getLong("profile_id"));
                profile.setEmail(resultSet.getString("email"));

                account.setProfile(profile);

                return Optional.of(account);
            }
            return Optional.empty();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateById(Long id, String nName, String nUsername, String nPassword ) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres", "8948");
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE accounts SET name = ?, username = ?, password = ? WHERE id = ?");
            preparedStatement.setString(1,nName);
            preparedStatement.setString(2,nUsername);
            preparedStatement.setString(3,nPassword);
            preparedStatement.setLong(4,id);
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Account> findAll(){

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres", "8948");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM accounts JOIN profiles ON accounts.profile_id = profiles.id");
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Account> accounts = new ArrayList<>();

            while (resultSet.next()){
                Account account = new Account();
                account.setId(resultSet.getLong("id"));
                account.setName(resultSet.getString("name"));
                account.setUsername(resultSet.getString("username"));
                account.setPassword(resultSet.getString("password"));

                Profile profile = new Profile();
                profile.setId(resultSet.getLong("profile_id"));
                profile.setEmail(resultSet.getString("email"));

                account.setProfile(profile);


            }
            return accounts;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void deleteById(Long id) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres", "8948");
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE * FROM accounts WHERE id = ? RETURNING profile_id");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            long pId = resultSet.getLong("profile_id");

            PreparedStatement preparedStatement2 = connection.prepareStatement("DELETE FROM profiles WHERE id = ?");
            preparedStatement2.setLong(1, pId);
            preparedStatement2.executeUpdate();
            connection.commit();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
