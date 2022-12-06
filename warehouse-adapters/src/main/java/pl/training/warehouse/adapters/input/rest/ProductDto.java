package pl.training.warehouse.adapters.input.rest;

import lombok.Data;

@Data
public class ProductDto {

    private Long id;
    private String name;
    private double price;

}
