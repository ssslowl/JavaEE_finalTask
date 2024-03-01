import db.DbManager;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(value = "/register")
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.getRequestDispatcher("register.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String fullname = req.getParameter("fullname");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirm password");

        req.setAttribute("result", "fill all the fields");



        if (username != "" && fullname != "" && password != "" && confirmPassword != "") {


            req.setAttribute("result", "passwords must be equal");

            if(password.equals(confirmPassword)) {
                User newUser = new User(username, password, fullname, 2);


                try {
                    DbManager.createUser(newUser);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                req.setAttribute("result", "You registered successful");
                resp.sendRedirect("login");
                return;
            }


        }

        req.getRequestDispatcher("register.jsp").forward(req, resp);


    }
}
