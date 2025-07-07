package controller.admin.backheritage;

import controller.BaseServlet;
import dao.admin.AdminHeritageDao;
import dao.impl.admin.AdminHeritageDaoImpl;
import model.Heritage;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/admin/heritage/edit")
public class HeritageEditServlet extends BaseServlet {

    private AdminHeritageDao heritageDao = new AdminHeritageDaoImpl();

    // 显示编辑页面
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        if (id == null || id.isEmpty()) {
            resp.sendRedirect(req.getContextPath() + "/admin/backheritage");
            return;
        }

        Heritage heritage = heritageDao.findById(id);
        if (heritage == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Heritage not found");
            return;
        }

        WebContext ctx = new WebContext(req, resp, getServletContext(), req.getLocale());
        ctx.setVariable("heritage", heritage);

        resp.setContentType("text/html;charset=UTF-8");
        templateEngine.process("admin/heritagePages/heritage-edit", ctx, resp.getWriter());
    }

    // 提交编辑数据
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String category = req.getParameter("category");
        String description = req.getParameter("description");

        Heritage heritage = new Heritage();
        heritage.setId(id);
        heritage.setName(name);
        heritage.setCategory(category);
        heritage.setDescription(description);

        boolean updated = heritageDao.update(heritage);

        if (updated) {
            resp.sendRedirect(req.getContextPath() + "/admin/backheritage");
        } else {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "更新失败");
        }
    }
}
