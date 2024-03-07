package hello.tobyspringboot;

import hello.tobyspringboot.helloboot.HelloController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class HelloControllerTest {
    @Test
    void failsHelloController(){
        HelloController helloController = new HelloController(name -> name);
        Assertions.assertThatThrownBy(()->{
            String ret = helloController.hello(null);
        }).isInstanceOf(NullPointerException.class);
        Assertions.assertThatThrownBy(()->{
            String ret = helloController.hello("");
        }).isInstanceOf(NullPointerException.class);
    }

}