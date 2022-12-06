package pl.training.warehouse.ports;

import lombok.Value;

@Value
public class Product {

    Long id;
    String name;
    Double price;

}
