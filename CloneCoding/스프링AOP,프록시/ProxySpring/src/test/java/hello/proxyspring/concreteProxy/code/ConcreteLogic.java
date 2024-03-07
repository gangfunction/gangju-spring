package hello.proxyspring.concreteProxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcreteLogic {
    public String operation() {
        log.info("ConcreteLogic실행");
        return "data";
    }
}
