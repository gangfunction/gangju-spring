package hello.springadvanced.app.v4;

import hello.springadvanced.trace.TraceStatus;
import hello.springadvanced.trace.logtrace.LogTrace;
import hello.springadvanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV4 {
    private final OrderRepositoryV4 orderRepositoryV4;
    private final LogTrace trace;
    public void orderItem(String itemId) {

        AbstractTemplate<Void> template = new AbstractTemplate<Void>() {
            @Override
            protected Void call() {
                orderRepositoryV4.save(itemId);
                return "ok";
            }
        }
        TraceStatus status = null;
        try{
            status = trace.begin("OrderService.orderItem()");
            orderRepositoryV4.save(itemId);
            trace.end(status);
        }
        catch(Exception e){
            trace.exception(status,e);
            throw e;
        }
    }
}
