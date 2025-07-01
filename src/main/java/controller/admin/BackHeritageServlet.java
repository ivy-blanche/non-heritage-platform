package controller.admin;

import controller.BaseServlet;
import model.Admin;
import model.Heritage;
import org.thymeleaf.context.WebContext;
import service.admin.HeritageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/backheritage")
public class BackHeritageServlet extends BaseServlet {

    private final HeritageService heritageService = new HeritageService();

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

        // 查询所有非遗项目
        List<Heritage> heritageList = heritageService.getAllHeritages();

        // 准备 thymeleaf 上下文
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("admin", admin);
        context.setVariable("heritageList", heritageList);
        context.setVariable("activeMenu", "backheritage"); // 用于侧边栏高亮

        templateEngine.process("admin/backheritage", context, resp.getWriter());
    }
}
