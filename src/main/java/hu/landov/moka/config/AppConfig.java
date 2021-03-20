package hu.landov.moka.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ DBConfig.class, RabbitConfig.class, SecurityConfig.class })
@ComponentScan(basePackages = {"hu.landov.moka"})
public class AppConfig {
}
