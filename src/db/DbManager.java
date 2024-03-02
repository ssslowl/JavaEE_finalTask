package db;

import models.NewsCategory;
import models.Post;
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

        String sql = "INSERT INTO users (username, password, full_name, role_id) VALUES ( '" +
                newUser.getEmail() + "', '" +
                newUser.getPassword() + "', '" +
                newUser.getFullName() + "', '" +
                newUser.getRole() + "')";
        int result = stmnt.executeUpdate(sql);

        return result;
    }


    public static User getUser(String username) {
        User user = null;

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE username = ?");

            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong("id"));
                user.setUsername(resultSet.getString("username"));
                user.setFullName(resultSet.getString("full_name"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getInt("role_id"));
            }
            statement.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }


    public static int addCategory(NewsCategory category) throws SQLException {
        Statement statement = connection.createStatement();

        String sql = "INSERT INTO news_categories (name) VALUES ('" +
                category.getName() + "')";
        Integer result = statement.executeUpdate(sql);

        return result;
    }


    public static List<NewsCategory> categoryList() throws SQLException {
        List<NewsCategory> categoryList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM news_categories");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                NewsCategory category = new NewsCategory(resultSet.getInt("id"), resultSet.getString("name"));
                categoryList.add(category);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categoryList;
    }



    public static int addPost (Post post) throws SQLException{
        try {
            Statement statement = connection.createStatement();

            String sql = "INSERT INTO news (post_date, category_id, title, content) VALUES (NOW()," +
                    post.getCategory_id()+
                    ", '"+post.getTitle()+"'"+
                    ", '"+post.getContent()+"'"+
                    ")";
            Integer result = statement.executeUpdate(sql);

            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Post> getPosts () throws SQLException {
        List<Post> posts = new ArrayList<>();

        try{
        PreparedStatement statement = connection.prepareStatement("SELECT n.id, n.post_date, nc.id as category_id, n.title, n.content, nc.name FROM news n INNER JOIN news_categories nc ON n.category_id = nc.id");

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            Post post = new Post();
            post.setId(resultSet.getInt("id"));
            post.setCategory_id(resultSet.getInt("category_id"));
            post.setPost_date(String.valueOf(resultSet.getDate("post_date")));
            post.setTitle(resultSet.getString("title"));
            post.setContent(resultSet.getString("content"));
            post.setCategoryName(resultSet.getString("name"));

            posts.add(post);
        }

            return  posts;
        }catch (Exception e){
            e.printStackTrace();
        }

        return posts;
    }


}
