package controller.admin.backinheritor;

import controller.BaseServlet;
import dao.admin.AdminInheritorDao;
import dao.impl.admin.AdminInheritorDaoImpl;
import model.Inheritor;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/admin/inheritor/edit")
public class InheritorEditServlet extends BaseServlet {

    private AdminInheritorDao inheritorDao = new AdminInheritorDaoImpl();

    // 显示编辑页面
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        if (id == null || id.isEmpty()) {
            resp.sendRedirect(req.getContextPath() + "/admin/backinheritor");
            return;
        }

        Inheritor inheritor = inheritorDao.findById(id);
        if (inheritor == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Inheritor not found");
            return;
        }

        WebContext ctx = new WebContext(req, resp, getServletContext(), req.getLocale());
        ctx.setVariable("inheritor", inheritor);

        resp.setContentType("text/html;charset=UTF-8");
        templateEngine.process("admin/inheritorPages/inheritor-edit", ctx, resp.getWriter());
    }

    // 提交编辑数据
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String ethnicity = req.getParameter("ethnicity");
        String category = req.getParameter("category");
        String projectName = req.getParameter("project_name");
        String projectId = req.getParameter("project_id");
        String bio = req.getParameter("bio");

        Inheritor inheritor = new Inheritor();
        inheritor.setId(id);
        inheritor.setName(name);
        inheritor.setGender(gender);
        inheritor.setEthnicity(ethnicity);
        inheritor.setCategory(category);
        inheritor.setProjectName(projectName);
        inheritor.setProjectId(projectId);
        inheritor.setBio(bio);

        boolean updated = inheritorDao.update(inheritor);

        if (updated) {
            resp.sendRedirect(req.getContextPath() + "/admin/backinheritor");
        } else {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "更新失败");
        }
    }
}
