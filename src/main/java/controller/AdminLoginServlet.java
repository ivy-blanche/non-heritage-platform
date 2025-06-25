package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.Admin;
import service.AdminService;

import java.io.IOException;

/**
 * AdminLoginServlet 类
 * 处理管理员登录请求的 Servlet 控制器
 *
 * 路径映射：/adminlogin
 * 功能说明：
 * - 接收管理员登录表单提交的用户名和密码
 * - 调用 AdminService 验证身份
 * - 登录成功后将管理员信息存入 session，并重定向至后台首页
 * - 登录失败时设置错误信息并返回登录页面
 */
@WebServlet("/adminlogin")
public class AdminLoginServlet extends HttpServlet {

    private AdminService adminService = new AdminService();

    /**
     * 处理管理员登录的 POST 请求
     *
     * @param req  HTTP 请求对象，包含管理员提交的登录信息
     * @param resp HTTP 响应对象，用于重定向或请求转发
     * @throws ServletException Servlet 异常
     * @throws IOException      IO 异常
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // 设置请求编码为 UTF-8，防止中文乱码
        req.setCharacterEncoding("UTF-8");

        // 获取表单提交的用户名和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 调用业务层进行身份验证
        Admin admin = adminService.login(username, password);

        if (admin != null) {
            // 登录成功，将管理员信息保存到 session 并跳转后台主页
            HttpSession session = req.getSession();
            session.setAttribute("admin", admin);
            resp.sendRedirect(req.getContextPath() + "/admin/dashboard");
        } else {
            // 登录失败，设置错误提示信息，转发回登录页面
            req.setAttribute("error", "用户名或密码错误");
            req.getRequestDispatcher("/admin/admin-login.html").forward(req, resp);
        }
    }
}
