package pl.training.orders.adapters.input.rest;

import lombok.Data;

@Data
public class OrderEntryDto {

    private Long productId;
    private int quantity;

}
