package hello.tobyspringboot.study;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class ConditionalTest {
    @Test
    void conditional(){
        ApplicationContextRunner contextRunner = new ApplicationContextRunner();
        contextRunner.withUserConfiguration(Config1.class)
                .run(context->{
                    assertThat(context).hasSingleBean(MyBean.class);
                    assertThat(context).hasSingleBean(Config1.class);
                });


        new ApplicationContextRunner().withUserConfiguration(Config2.class)
                .run(context->{
                    assertThat(context).doesNotHaveBean(MyBean.class);
                    assertThat(context).doesNotHaveBean(Config1.class);
                });
    }
    @Configuration
    static class Config1{
        @Bean
        MyBean MyBean(){
            return new MyBean();
        }
    }
    @Configuration
    @Conditional(BooleanCondition.class)
    static class  Config2{
        @Bean
        MyBean MyBean(){
            return new MyBean();
        }
    }
    static class MyBean{}


    static class BooleanCondition implements Condition {
        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(BooleanCondition.class.getName());
            Boolean value = (Boolean) annotationAttributes.get("value");
            return value;
        }
    }


}
