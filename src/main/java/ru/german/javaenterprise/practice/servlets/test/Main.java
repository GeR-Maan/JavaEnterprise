package ru.german.javaenterprise.practice.servlets.test;

public class Main {

/*    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","8948");
            //Statement statement = connection.createStatement();
            //statement.executeUpdate("DROP TABLE IF EXISTS employees");

            *//*PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO accounts VALUES (default,?,?,?)");
            preparedStatement.setString(1,"Name");
            preparedStatement.setString(2,"username");
            preparedStatement.setString(3,"password");
            preparedStatement.executeUpdate();*//*

            PreparedStatement preparedStatement = connection.prepareStatement("select * from accounts WHERE name = ?");
            preparedStatement.setString(1,"German");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString(2);
                String password = resultSet.getString(3);
                System.out.println(id + " " + name + " " + password);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }*/

}
