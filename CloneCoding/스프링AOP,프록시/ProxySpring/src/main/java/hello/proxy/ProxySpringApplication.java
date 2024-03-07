package hello.proxy;

import hello.proxy.config.v4.BeanPostProcessorConfig;
import hello.proxy.config.v5.AutoProxyConfig;
import hello.proxy.config.v6.AopConfig;
import hello.proxy.trace.LogTrace;
import hello.proxy.trace.ThreadLocalLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@Import(AopConfig.class)
@SpringBootApplication(scanBasePackages = "hello.proxy.app")
public class ProxySpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProxySpringApplication.class, args);
    }
    @Bean
    public LogTrace logTrace(){
        return new ThreadLocalLogTrace();
    }

}
