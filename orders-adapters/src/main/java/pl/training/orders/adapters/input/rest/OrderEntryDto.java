package pl.training.orders.adapters.input.rest;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderEntryDto {

    private Long productId;
    private BigDecimal price;
    private int quantity;

}
