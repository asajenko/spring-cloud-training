package pl.training.orders.ports.model;

import lombok.Value;

import java.math.BigDecimal;
import java.util.List;

@Value
public class Order {

    Long id;
    List<OrderEntry> entries;

    public BigDecimal getTotalValue() {
        return entries.stream()
                .map(OrderEntry::getTotalValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
