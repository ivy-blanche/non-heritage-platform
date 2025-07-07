package controller.user;

import controller.BaseServlet;
import model.Inheritor;
import org.thymeleaf.context.WebContext;
import service.user.FrontInheritorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/user/inheritor")
public class FrontInheritorServlet extends BaseServlet {

    private final FrontInheritorService inheritorService = new FrontInheritorService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 查询所有传承人
        List<Inheritor> inheritorList = inheritorService.getAllInheritors();

        // 准备模板上下文
        WebContext context = new WebContext(req, resp, getServletContext(), req.getLocale());
        context.setVariable("inheritorList", inheritorList);

        // 渲染 Thymeleaf 模板 user/inheritor.html
        resp.setContentType("text/html;charset=UTF-8");
        templateEngine.process("user/inheritor", context, resp.getWriter());
    }
}
