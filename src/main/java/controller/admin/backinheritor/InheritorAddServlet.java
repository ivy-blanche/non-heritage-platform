package controller.admin.backinheritor;

import controller.BaseServlet;
import dao.admin.AdminInheritorDao;
import dao.impl.admin.AdminInheritorDaoImpl;
import model.Inheritor;
import org.thymeleaf.context.WebContext;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/admin/inheritor/add")
public class InheritorAddServlet extends BaseServlet {

    private AdminInheritorDao inheritorDao = new AdminInheritorDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        WebContext ctx = new WebContext(req, resp, getServletContext(), req.getLocale());
        resp.setContentType("text/html;charset=UTF-8");
        templateEngine.process("admin/inheritorPages/inheritor-add", ctx, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String ethnicity = req.getParameter("ethnicity");
        String category = req.getParameter("category");
        String projectName = req.getParameter("project_name");
        String projectId = req.getParameter("project_id");
        String bio = req.getParameter("bio");

        // 先判断ID是否存在
        if (inheritorDao.existsById(id)) {
            WebContext ctx = new WebContext(req, resp, getServletContext(), req.getLocale());
            ctx.setVariable("error", "exists");
            ctx.setVariable("inheritor", new Inheritor(id, name, gender, ethnicity, category, projectName, projectId, bio));
            resp.setContentType("text/html;charset=UTF-8");
            templateEngine.process("admin/inheritorPages/inheritor-add", ctx, resp.getWriter());
            return;
        }

        Inheritor inheritor = new Inheritor();
        inheritor.setId(id);
        inheritor.setName(name);
        inheritor.setGender(gender);
        inheritor.setEthnicity(ethnicity);
        inheritor.setCategory(category);
        inheritor.setProjectName(projectName);
        inheritor.setProjectId(projectId);
        inheritor.setBio(bio);

        boolean success = inheritorDao.add(inheritor);

        if (success) {
            resp.sendRedirect(req.getContextPath() + "/admin/backinheritor");
        } else {
            WebContext ctx = new WebContext(req, resp, getServletContext(), req.getLocale());
            ctx.setVariable("error", "fail");
            resp.setContentType("text/html;charset=UTF-8");
            templateEngine.process("admin/inheritorPages/inheritor-add", ctx, resp.getWriter());
        }
    }
}
