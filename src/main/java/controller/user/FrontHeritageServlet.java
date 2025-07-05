package controller.user;

import controller.BaseServlet;
import org.thymeleaf.context.WebContext;
import service.user.FrontHeritageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/user/heritage")
public class FrontHeritageServlet extends BaseServlet {

    private FrontHeritageService heritageService = new FrontHeritageService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 防止中文乱码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        WebContext context;
        context = new WebContext(req, resp, getServletContext());

        templateEngine.process("user/heritage", context, resp.getWriter());

    }
}
