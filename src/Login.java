import db.DbManager;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(value = "/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getSession().getAttribute("user") != null){
            resp.sendRedirect("home");
            return;
        }

        req.getRequestDispatcher("login.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = DbManager.getUser(req.getParameter("username"));

        req.setAttribute("result", "incorrect username or password");

        System.out.println(user);

        if (user != null && user.getPassword().equals(req.getParameter("password"))) {
            req.setAttribute("result", "incorrect password");
            req.setAttribute("result", "success");
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("home");
            return;
        }

        req.getRequestDispatcher("login.jsp").forward(req, resp);


    }
}
