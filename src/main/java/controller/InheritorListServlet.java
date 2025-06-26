package controller;

import model.Inheritor;
import service.InheritorService;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/dashboard")
public class InheritorListServlet extends BaseServlet {
    private InheritorService service = new InheritorService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        List<Inheritor> list = service.getAllInheritors();
        WebContext context = new WebContext(req, resp, getServletContext());
        context.setVariable("heritageList", list);
        templateEngine.process("admin/dashboard", context, resp.getWriter());

    }
}
