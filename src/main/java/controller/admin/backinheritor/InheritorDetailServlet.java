package controller.admin.backinheritor;

import controller.BaseServlet;
import dao.admin.InheritorDao;
import dao.impl.admin.InheritorDaoImpl;
import model.Inheritor;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/admin/inheritor/detail")
public class InheritorDetailServlet extends BaseServlet {

    private InheritorDao inheritorDao = new InheritorDaoImpl();

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
        templateEngine.process("admin/inheritorPages/inheritor-detail", ctx, resp.getWriter());
    }
}
