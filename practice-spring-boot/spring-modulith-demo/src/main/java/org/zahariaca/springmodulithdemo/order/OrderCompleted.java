package org.zahariaca.springmodulithdemo.order;

import org.jmolecules.event.types.DomainEvent;

public record OrderCompleted(Order.OrderIdentifier orderId) implements DomainEvent {
}
