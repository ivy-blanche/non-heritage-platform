package controller.admin.backheritage;

import controller.BaseServlet;
import dao.admin.HeritageDao;
import dao.impl.admin.HeritageDaoImpl;
import model.Heritage;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/admin/heritage/detail")
public class HeritageDetailServlet extends BaseServlet {

    private HeritageDao heritageDao = new HeritageDaoImpl();

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

        // 创建 Thymeleaf WebContext，绑定 request、response、servletContext 和 locale
        WebContext ctx = new WebContext(req, resp, getServletContext(), req.getLocale());

        // 把heritage对象放到上下文
        ctx.setVariable("heritage", heritage);

        // 处理模板并写回响应
        resp.setContentType("text/html;charset=UTF-8");
        templateEngine.process("admin/heritagePages/heritage-detail", ctx, resp.getWriter());
    }
}
