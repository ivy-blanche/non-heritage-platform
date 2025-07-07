package controller.admin.backheritage;

import controller.BaseServlet;
import dao.admin.AdminHeritageDao;
import dao.impl.admin.AdminHeritageDaoImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/admin/heritage/delete")
public class HeritageDeleteServlet extends BaseServlet {

    private AdminHeritageDao heritageDao = new AdminHeritageDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");

        if (id != null && !id.isEmpty()) {
            heritageDao.deleteById(id);
        }

        // 删除后重定向回列表页面
        resp.sendRedirect(req.getContextPath() + "/admin/backheritage");
    }
}
