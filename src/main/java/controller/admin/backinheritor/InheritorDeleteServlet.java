package controller.admin.backinheritor;

import controller.BaseServlet;
import dao.admin.AdminInheritorDao;
import dao.impl.admin.AdminInheritorDaoImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/admin/inheritor/delete")
public class InheritorDeleteServlet extends BaseServlet {

    private AdminInheritorDao inheritorDao = new AdminInheritorDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");

        if (id != null && !id.isEmpty()) {
            inheritorDao.deleteById(id);
        }

        // 删除后重定向回传承人列表页面
        resp.sendRedirect(req.getContextPath() + "/admin/backinheritor");
    }
}
