package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

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
            resp.sendRedirect(req.getContextPath() + "/admin/dashboard"); // 登录成功跳转后台主页
        } else {
            req.setAttribute("error", "用户名或密码错误");
            // 使用请求转发回登录页面，保持错误信息
            req.getRequestDispatcher("/admin/admin-login.html").forward(req, resp);
        }
    }
}
