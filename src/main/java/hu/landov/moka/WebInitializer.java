package hu.landov.moka;

import hu.landov.moka.config.DBConfig;
import hu.landov.moka.config.RabbitConfig;
import hu.landov.moka.config.SecurityConfig;
import hu.landov.moka.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{
                DBConfig.class, RabbitConfig.class, SecurityConfig.class
        };
    }
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{
                WebConfig.class
        };
    }
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
