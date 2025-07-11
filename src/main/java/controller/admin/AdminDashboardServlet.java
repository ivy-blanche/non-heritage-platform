package controller.admin;

import controller.BaseServlet;
import model.Admin;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/admin/dashboard")
public class AdminDashboardServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("admin") == null) {
            resp.sendRedirect(req.getContextPath() + "/admin/admin_login.html");
            return;
        }

        Admin admin = (Admin) session.getAttribute("admin");

        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("admin", admin);
        context.setVariable("activeMenu", ""); // 首页不高亮菜单

        templateEngine.process("admin/dashboard", context, resp.getWriter());
    }
}
