package controller.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.User;
import service.user.UserService;

import java.io.IOException;

/**
 * UserLoginServlet 类
 * 处理用户登录请求的 Servlet 控制器
 * <p>
 * 路径映射：/login
 * 功能说明：
 * - 接收登录表单提交的用户名和密码
 * - 调用 UserService 进行身份验证
 * - 验证成功后创建会话并重定向到主页
 * - 验证失败则返回登录页面并提示错误信息
 */
@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {

    private UserService userService = new UserService();

    /**
     * 处理 POST 请求，执行用户登录操作
     *
     * @param req  HTTP 请求对象，包含用户名和密码参数
     * @param resp HTTP 响应对象，用于重定向或转发页面
     * @throws ServletException Servlet 异常
     * @throws IOException      IO 异常
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // 设置请求编码，防止中文乱码
        req.setCharacterEncoding("UTF-8");

        // 获取表单提交的用户名和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 调用业务层进行登录验证
        User user = userService.login(username, password);

        if (user != null) {
            // 登录成功，保存用户到 session，并重定向到首页
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            resp.sendRedirect(req.getContextPath() + "/index.html");
        } else {
            // 登录失败，设置错误提示并返回登录页面
            req.setAttribute("error", "用户名或密码错误");
            req.getRequestDispatcher("/user_login.html").forward(req, resp);
        }
    }
}
