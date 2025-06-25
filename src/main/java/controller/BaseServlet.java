package controller;

import javax.servlet.http.HttpServlet;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

public class BaseServlet extends HttpServlet {
    protected TemplateEngine templateEngine;

    @Override
    public void init() {
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setPrefix("templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML");
        resolver.setCharacterEncoding("UTF-8");
        resolver.setCacheable(false); // 开发阶段关闭缓存，修改模板后不用重启服务器

        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(resolver);
    }
}
