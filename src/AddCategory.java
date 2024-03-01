import db.DbManager;
import models.NewsCategory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/addCategory")
public class AddCategory extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.getRequestDispatcher("addCategory.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("category");

        NewsCategory category = new NewsCategory();

        category.setName(name);

        try {
            Integer result = DbManager.addPost(category);
            if(result == 0){
                req.setAttribute("result", "An error has occured");
            }else{
                req.setAttribute("result", "a category has been added succesfuly");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        req.getRequestDispatcher("addCategory.jsp").forward(req, resp);
    }
}
