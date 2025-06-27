package controller.user;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.BaseServlet;
import org.thymeleaf.context.WebContext;

import java.io.IOException;

@WebServlet("/user/inheritor")
public class FrontInheritorServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        WebContext context = new WebContext(req, resp, getServletContext());
// 防止中文乱码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        // 传给模板的数据，例如：
        // context.setVariable("message", "欢迎来到非遗项目页面");

        templateEngine.process("user/heritage", context, resp.getWriter());
    }
}

