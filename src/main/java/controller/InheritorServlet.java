package controller;

import javax.servlet.annotation.WebServlet;
import javax .servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.thymeleaf.context.WebContext;

import java.io.IOException;
@WebServlet("/user/inheritor")
public class InheritorServlet extends BaseServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        WebContext context = new WebContext(req, resp, getServletContext());


        // 传给模板的数据，例如：
        // context.setVariable("message", "欢迎来到非遗项目页面");

        templateEngine.process("user/heritage", context, resp.getWriter());
    }
}

