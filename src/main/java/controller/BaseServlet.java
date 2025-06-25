package controller;

import javax.servlet.http.HttpServlet;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

/**
 * BaseServlet 类
 * 用于封装 Thymeleaf 模板引擎的初始化逻辑，供其他 Servlet 继承使用
 *
 * 功能说明：
 * - 设置模板路径、文件后缀、模板类型、字符集等参数
 * - 在 Servlet 初始化阶段完成模板引擎的配置
 * - 关闭模板缓存，便于开发时动态更新模板文件
 *
 * 模板目录约定：/WEB-INF/classes/templates/
 */
public class BaseServlet extends HttpServlet {

    // 共享的 Thymeleaf 模板引擎对象，供子类使用
    protected TemplateEngine templateEngine;

    /**
     * Servlet 初始化方法
     * 配置 Thymeleaf 的模板解析器和模板引擎
     */
    @Override
    public void init() {
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();

        // 设置模板所在目录（相对于 classpath）
        resolver.setPrefix("templates/");
        // 设置模板文件后缀
        resolver.setSuffix(".html");
        // 指定模板类型
        resolver.setTemplateMode("HTML");
        // 设置字符编码
        resolver.setCharacterEncoding("UTF-8");
        // 禁用模板缓存，便于开发时即时生效
        resolver.setCacheable(false);

        // 创建模板引擎并设置解析器
        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(resolver);
    }
}
