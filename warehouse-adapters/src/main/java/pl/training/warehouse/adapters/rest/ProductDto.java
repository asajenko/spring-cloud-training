package pl.training.warehouse.adapters.rest;

import lombok.Data;

@Data
public class ProductDto {

    private Long id;
    private String name;
    private Double price;

}
