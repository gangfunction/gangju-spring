package hello.tobyspringboot.config.autoconfig;

import hello.tobyspringboot.config.ConditionalMyONclass;
import hello.tobyspringboot.config.EnableMyConfigurationProperties;
import hello.tobyspringboot.config.MyAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@MyAutoConfiguration
@ConditionalMyONclass("org.apache.catalina.startup.Tomcat")
@EnableMyConfigurationProperties(ServerProperties.class)
public class TomcatWebServerConfig {

    @Bean("tomcatWebServerFactory")
    @ConditionalOnMissingBean
    public ServletWebServerFactory servletWebServerFactory(ServerProperties properties){
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        System.out.println(properties.getContextPath());
        factory.setContextPath(properties.getContextPath());
        factory.setPort(properties.getPort());
        return factory;
    }


}
