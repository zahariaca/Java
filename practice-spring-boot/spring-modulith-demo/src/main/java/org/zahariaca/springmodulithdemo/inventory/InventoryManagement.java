package org.zahariaca.springmodulithdemo.inventory;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;
import org.zahariaca.springmodulithdemo.order.OrderCompleted;
import org.zahariaca.springmodulithdemo.order.internal.OrderInternal;

@Service
@Slf4j
@RequiredArgsConstructor
class InventoryManagement {
    private final InventoryInternal dependency;

    @ApplicationModuleListener
    void on(OrderCompleted event) throws InterruptedException {

        var orderId = event.orderId();

        var orderInternal = new OrderInternal();
        log.info("Received order completion for {}.", orderId);

        // Simulate busy work
        Thread.sleep(1000);

        log.info("Finished order completion for {}.", orderId);
    }
}
