package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.User;
import service.UserService;

import java.io.IOException;

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = userService.login(username, password);

        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            resp.sendRedirect(req.getContextPath() + "/index.html");
        } else {
            req.setAttribute("error", "用户名或密码错误");
            req.getRequestDispatcher("/user_login.html").forward(req, resp);
        }
    }
}
