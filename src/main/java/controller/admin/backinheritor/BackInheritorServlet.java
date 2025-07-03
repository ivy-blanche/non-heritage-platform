package controller.admin.backinheritor;

import controller.BaseServlet;
import model.Admin;
import model.Inheritor;
import org.thymeleaf.context.WebContext;
import service.admin.InheritorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/backinheritor")
public class BackInheritorServlet extends BaseServlet {

    private final InheritorService inheritorService = new InheritorService();

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

        List<Inheritor> inheritorList = inheritorService.getAllInheritors();

        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("admin", admin);
        context.setVariable("inheritorList", inheritorList);
        context.setVariable("activeMenu", "backinheritor");

        templateEngine.process("admin/inheritorPages/backinheritor", context, resp.getWriter());
    }
}
