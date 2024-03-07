package hello.springadvanced.app.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV1 {
    private final OrderRepositoryV1 orderRepositoryV1;
    void orderItem(String itemId) throws InterruptedException {
        orderRepositoryV1.save(itemId);
    }
}
