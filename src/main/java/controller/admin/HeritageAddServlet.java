package controller.admin;

import controller.BaseServlet;
import dao.admin.HeritageDao;
import dao.impl.admin.HeritageDaoImpl;
import model.Heritage;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/admin/heritage/add")
public class HeritageAddServlet extends BaseServlet {

    private HeritageDao heritageDao = new HeritageDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        WebContext ctx = new WebContext(req, resp, getServletContext(), req.getLocale());
        resp.setContentType("text/html;charset=UTF-8");
        templateEngine.process("admin/heritage-add", ctx, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");

        // 获取表单参数
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String category = req.getParameter("category");
        String description = req.getParameter("description");

        // 构建 Heritage 对象
        Heritage h = new Heritage();
        h.setId(id);
        h.setName(name);
        h.setCategory(category);
        h.setDescription(description);

        // 插入数据库
        boolean success = heritageDao.add(h);

        // 添加成功后重定向到列表页，失败则返回原页面（可以后期加提示）
        if (success) {
            resp.sendRedirect(req.getContextPath() + "/admin/backheritage");
        } else {
            resp.sendRedirect(req.getContextPath() + "/admin/heritage/add");
        }
    }
}
