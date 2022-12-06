package pl.training.warehouse.domain.model;

import lombok.Value;

@Value
public class ProductDomain {

    Long id;
    String name;
    double price;

}
