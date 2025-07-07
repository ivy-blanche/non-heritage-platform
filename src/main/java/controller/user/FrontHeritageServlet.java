package controller.user;

import controller.BaseServlet;
import model.Heritage;
import org.thymeleaf.context.WebContext;
import service.user.FrontHeritageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/user/heritage")
public class FrontHeritageServlet extends BaseServlet {

    private final FrontHeritageService heritageService = new FrontHeritageService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        List<Heritage> heritageList = heritageService.getAllHeritages();

        WebContext context = new WebContext(req, resp, getServletContext());
        context.setVariable("heritageList", heritageList);

        // 可选：页面中若需用 [[${ctx}]] 可开启
        // context.setVariable("ctx", req.getContextPath());

        templateEngine.process("user/heritage", context, resp.getWriter());
    }
}
