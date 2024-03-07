package hello.proxyspring.referenceTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Proxy implements OriginalTarget {
    OriginalTarget target;
    String tempValue;

    public Proxy(OriginalTarget target) {
        this.target = target;
    }

    @Override
    public String operation() {
        log.info("프록시 동작");
        if(tempValue == null){
            tempValue = target.operation();
        }
        return tempValue;
    }
}
