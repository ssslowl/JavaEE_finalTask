import db.DbManager;
import models.NewsCategory;
import models.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/addPost")
public class AddPost extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.getRequestDispatcher("addPost.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        Integer category = Integer.valueOf(req.getParameter("category"));


        req.setAttribute("resultType", "danger");
        req.setAttribute("result", "fill all the fields");
        Post post = new Post();
        if (!title.equals("") && !content.equals("") && category != 0) {

            post.setTitle(title);
            post.setContent(content);
            post.setCategory_id(category);

            try {
                Integer result = DbManager.addPost(post);
                if (result == 0) {
                    req.setAttribute("resultType", "danger");
                    req.setAttribute("result", "An error has occured");
                } else {
                    req.setAttribute("resultType", "success");
                    req.setAttribute("result", "a category has been added succesfuly");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        req.getRequestDispatcher("addPost.jsp").forward(req, resp);
    }
}
