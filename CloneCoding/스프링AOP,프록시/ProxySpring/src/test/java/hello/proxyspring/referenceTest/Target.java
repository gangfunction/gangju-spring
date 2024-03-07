package hello.proxyspring.referenceTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Target implements OriginalTarget {
    @Override
    public String operation() {
        log.info("타겟 동작");
        return "target";
    }
}
