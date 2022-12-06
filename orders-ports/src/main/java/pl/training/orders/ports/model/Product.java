package pl.training.orders.ports.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {

    private Long id;
    private BigDecimal price;

}
