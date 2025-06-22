package controller;


import dao.UserDao;
import dao.impl.UserDaoImpl;
import model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {

    private UserDao userDao = new UserDaoImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            req.setAttribute("error", "用户名或密码不能为空");
            req.getRequestDispatcher("/user_login.html").forward(req, resp);
            return;
        }

        User user = userDao.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            // 登录成功，存入 session
            HttpSession session = req.getSession();
            session.setAttribute("user", user);

            // 跳转用户首页
            resp.sendRedirect(req.getContextPath() + "/index.html");

        } else {
            // 登录失败，回显错误信息
            req.setAttribute("error", "用户名或密码错误");
            req.getRequestDispatcher("/user_login.html").forward(req, resp);
        }
    }
}
