package controller.user;

import controller.BaseServlet;
import org.thymeleaf.context.WebContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/user/workshop")
public class WorkshopServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 防止中文乱码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        // 渲染模板（不传数据）
        WebContext context = new WebContext(req, resp, getServletContext());
        templateEngine.process("user/workshop", context, resp.getWriter());
    }
}
