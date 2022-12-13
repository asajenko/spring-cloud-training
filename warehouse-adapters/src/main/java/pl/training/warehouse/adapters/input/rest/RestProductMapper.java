package pl.training.warehouse.adapters.input.rest;

import org.mapstruct.Mapper;
import pl.training.warehouse.ports.model.Product;

@Mapper(componentModel = "spring")
public interface RestProductMapper {

    ProductDto toDto(Product product);

}
