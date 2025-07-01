package controller.user;

import controller.BaseServlet;
import org.thymeleaf.context.WebContext;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/reservation")
public class ReservationServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 防止中文乱码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        // 渲染模板（不传数据）
        WebContext context = new WebContext(req, resp, getServletContext());
        templateEngine.process("user/reservation", context, resp.getWriter());
    }
}
