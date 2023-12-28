package org.zahariaca.springmodulithdemo.order;

import java.util.UUID;
import lombok.Getter;
import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.Identifier;

@Getter
public class Order implements AggregateRoot<Order, Order.OrderIdentifier> {
    private final OrderIdentifier id = new OrderIdentifier(UUID.randomUUID());

    public record OrderIdentifier(UUID id) implements Identifier {}
}
