package pl.training.warehouse.ports.model;

import lombok.Value;

@Value
public class Product {

    Long id;
    String name;
    double price;

}
