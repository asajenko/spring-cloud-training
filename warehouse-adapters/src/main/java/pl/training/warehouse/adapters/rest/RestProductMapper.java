package pl.training.warehouse.adapters.rest;

import org.mapstruct.Mapper;
import pl.training.warehouse.ports.Product;

@Mapper(componentModel = "spring")
public interface RestProductMapper {

    ProductDto toDto(Product product);

}
