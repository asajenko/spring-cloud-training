package pl.training.orders.ports.model;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class OrderEntry {

    Long productId;
    BigDecimal price;
    int quantity;

    public BigDecimal getTotalValue() {
        return price.multiply(BigDecimal.valueOf(quantity));
    }

}
