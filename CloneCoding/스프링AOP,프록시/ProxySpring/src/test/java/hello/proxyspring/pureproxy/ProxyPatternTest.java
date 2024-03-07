package hello.proxyspring.pureproxy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
@Slf4j
public class ProxyPatternTest {
    @Test
    void noProxyTest() {
        RealSubject realSubject = new RealSubject();
        ProxyPatternClient client = new ProxyPatternClient(realSubject);
        client.execute();
        client.execute();
        client.execute();
    }
    @Test
    void cacheProxyTest() {
        log.info("1단계");
        Subject realSubject = new RealSubject();
        log.info("2단계");

        Subject cacheProxy = new CacheProxy(realSubject);
        log.info("3단계");

        ProxyPatternClient client = new ProxyPatternClient(cacheProxy);
        log.info("4단계");

        client.execute();
        log.info("5단계");

        client.execute();
        log.info("6단계");

        client.execute();
    }
}
