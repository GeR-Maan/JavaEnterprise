package ru.german.javaenterprise.practice.storage;

import ru.german.javaenterprise.practice.models.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JdbcAccountStorage {

    public void save(Account account) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "8948");

            PreparedStatement preparedStatement1 = connection.prepareStatement("INSERT INTO profiles VALUES (default,?) RETURNING id");
            preparedStatement1.setString(1, account.getProfile().getEmail());
            ResultSet resultSet = preparedStatement1.executeQuery();
            resultSet.next();
            long id = resultSet.getLong("id");


            PreparedStatement preparedStatement2 = connection.prepareStatement("INSERT INTO accounts VALUES (default,?, ?, ?,?)");
            preparedStatement2.setString(1, account.getName());
            preparedStatement2.setString(2, account.getUsername());
            preparedStatement2.setString(3, account.getPassword());
            preparedStatement2.setLong(4, id);
            preparedStatement2.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Account> findAll() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "8948");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM accounts");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Account> accounts = new ArrayList<>();
            while (resultSet.next()) {
                Account account = new Account();
                account.setId(resultSet.getLong("id"));
                account.setName(resultSet.getString("name"));
                account.setUsername(resultSet.getString("username"));
                account.setPassword(resultSet.getString("password"));
                accounts.add(account);
            }
            return accounts;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Optional<Account> findByUsername(String username) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "8948");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM accounts WHERE username = ?");
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Account account = new Account();
                account.setId(resultSet.getLong("id"));
                account.setName(resultSet.getString("name"));
                account.setUsername(resultSet.getString("username"));
                account.setPassword(resultSet.getString("password"));
                return Optional.of(account);
            }
            return Optional.empty();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
