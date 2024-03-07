package hello.proxyspring.referenceTest;

import org.junit.jupiter.api.Test;

public class TestCaller {
    @Test
    void test1 (){
        OriginalTarget target = new Target();
        OriginalTarget proxy = new Proxy(target);
        proxy.operation();
        proxy.operation();
        proxy.operation();

    }
}
