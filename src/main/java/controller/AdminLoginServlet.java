package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import model.Admin;
import service.AdminService;

import java.io.IOException;

@WebServlet("/adminlogin")
public class AdminLoginServlet extends HttpServlet {

    private AdminService adminService = new AdminService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Admin admin = adminService.login(username, password);

        if (admin != null) {
            HttpSession session = req.getSession();
            session.setAttribute("admin", admin);
            resp.sendRedirect(req.getContextPath() + "/admin/dashboard.html"); // 管理员主页
        } else {
            req.setAttribute("error", "用户名或密码错误");
            resp.sendRedirect(req.getContextPath() + "/admin/admin-login.html");

        }
    }
}
