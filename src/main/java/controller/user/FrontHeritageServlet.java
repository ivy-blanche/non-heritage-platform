package controller.user;

import controller.BaseServlet;
import dao.impl.admin.HeritageDaoImpl;
import model.Heritage;
import org.thymeleaf.context.WebContext;
import service.user.FrontHeritageService;
import service.admin.HeritageService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/user/heritage")
public class FrontHeritageServlet extends BaseServlet {

    private final FrontHeritageService heritageService = new FrontHeritageService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 防止中文乱码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        List<Heritage> heritageList = heritageService.getAllHeritages();
        WebContext context ;
        context = new WebContext(req, resp, getServletContext());
        context.setVariable("heritageList", heritageList);
        templateEngine.process("user/heritage", context, resp.getWriter());

    }
}
