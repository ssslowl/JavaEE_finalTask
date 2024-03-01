package db;

import models.NewsCategory;
import models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbManager {
    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "qwerty");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static int createUser(User newUser) throws SQLException {
        Statement stmnt = connection.createStatement();

        String sql = "INSERT INTO users (username, password, full_name, role_id) VALUES ( '"  +
                newUser.getEmail() +"', '"+
                newUser.getPassword() + "', '" +
                newUser.getFullName()+"', '" +
                newUser.getRole() +"')";
        int result = stmnt.executeUpdate(sql);

        return result;
    }



    public static User getUser(String username){
        User user = null;

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE username = ?" );

            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                user = new User();
                user.setId(resultSet.getLong("id"));
                user.setUsername(resultSet.getString("username"));
                user.setFullName(resultSet.getString("full_name"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getInt("role_id"));
            }
            statement.close();


        }catch (Exception e){
            e.printStackTrace();
        }

        return user;
    }




    public static int addPost(NewsCategory category) throws SQLException {
        Statement statement = connection.createStatement();

        String sql = "INSERT INTO news_categories (name) VALUES ('" +
                category.getName() + "')";
        Integer result = statement.executeUpdate(sql);

        return result;
    }



}
