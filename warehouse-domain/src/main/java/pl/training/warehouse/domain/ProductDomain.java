package pl.training.warehouse.domain;

import lombok.Value;

@Value
class ProductDomain {

    Long id;
    String name;
    Double price;

}
