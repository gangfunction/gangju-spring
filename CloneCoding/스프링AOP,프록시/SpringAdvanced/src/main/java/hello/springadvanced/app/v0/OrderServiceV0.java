package hello.springadvanced.app.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV0 {
    private final OrderRepositoryV0 orderRepositoryV0;
    void orderItem(String itemId) throws InterruptedException {
        orderRepositoryV0.save(itemId);
    }
}
