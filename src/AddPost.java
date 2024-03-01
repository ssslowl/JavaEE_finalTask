import db.DbManager;
import models.NewsCategory;

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
        String name = req.getParameter("category");

        req.setAttribute("result", "fill all the fields");
        NewsCategory category = new NewsCategory();
        if (!name.equals("")) {
            category.setName(name);

            try {
                Integer result = DbManager.addCategory(category);
                if (result == 0) {
                    req.setAttribute("result", "An error has occured");
                } else {
                    req.setAttribute("result", "a category has been added succesfuly");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        req.getRequestDispatcher("addCategory.jsp").forward(req, resp);
    }
}
