package controller.admin.backheritage;

import controller.BaseServlet;
import dao.admin.AdminHeritageDao;
import dao.impl.admin.AdminHeritageDaoImpl;
import model.Heritage;
import org.thymeleaf.context.WebContext;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/admin/heritage/add")
public class HeritageAddServlet extends BaseServlet {

    private AdminHeritageDao heritageDao = new AdminHeritageDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        WebContext ctx = new WebContext(req, resp, getServletContext(), req.getLocale());
        resp.setContentType("text/html;charset=UTF-8");
        templateEngine.process("admin/heritagePages/heritage-add", ctx, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String category = req.getParameter("category");
        String description = req.getParameter("description");

        // 先判断ID是否存在
        if (heritageDao.existsById(id)) {
            // 如果存在，返回添加页面并显示错误
            WebContext ctx = new WebContext(req, resp, getServletContext(), req.getLocale());
            ctx.setVariable("error", "exists");
            // 保留表单数据，避免用户重新输入
            ctx.setVariable("heritage", new Heritage(id, name, category, description));
            resp.setContentType("text/html;charset=UTF-8");
            templateEngine.process("admin/heritagePages/heritage-add", ctx, resp.getWriter());
            return;
        }

        Heritage h = new Heritage();
        h.setId(id);
        h.setName(name);
        h.setCategory(category);
        h.setDescription(description);

        boolean success = heritageDao.add(h);

        if (success) {
            resp.sendRedirect(req.getContextPath() + "/admin/backheritage");
        } else {
            // 添加失败，返回添加页，可加错误提示
            WebContext ctx = new WebContext(req, resp, getServletContext(), req.getLocale());
            ctx.setVariable("error", "fail");
            resp.setContentType("text/html;charset=UTF-8");
            templateEngine.process("admin/heritagePages/heritage-add", ctx, resp.getWriter());
        }
    }

}
