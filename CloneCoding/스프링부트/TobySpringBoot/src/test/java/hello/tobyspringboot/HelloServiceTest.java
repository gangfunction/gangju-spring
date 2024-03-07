package hello.tobyspringboot;

import hello.tobyspringboot.helloboot.SimpleHelloService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class HelloServiceTest {
    @Test
    void simpleHelloServiceTest(){
        SimpleHelloService helloService = new SimpleHelloService();
        String ret = helloService.sayHello("Test");
        Assertions.assertThat(ret).isEqualTo("helloTest");
    }

}