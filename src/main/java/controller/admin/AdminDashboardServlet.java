package controller.admin;


import model.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/dashboard")
public class AdminDashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 设置请求编码为 UTF-8，防止中文乱码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("admin") == null) {
            // 未登录，重定向回登录页
            resp.sendRedirect(req.getContextPath() + "/admin/admin_login.html");
            return;
        }

        Admin admin = (Admin) session.getAttribute("admin");
        // 把 admin 放请求域，方便 thymeleaf 访问
        req.setAttribute("admin", admin);

        // 转发到 thymeleaf 模板
        req.getRequestDispatcher("admin/dashboard.html").forward(req, resp);
    }
}


