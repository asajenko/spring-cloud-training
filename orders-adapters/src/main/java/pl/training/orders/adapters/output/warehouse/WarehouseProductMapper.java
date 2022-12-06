package pl.training.orders.adapters.output.warehouse;

import org.mapstruct.Mapper;
import pl.training.orders.ports.model.Product;

@Mapper(componentModel = "spring")
public interface WarehouseProductMapper {

    Product toDomain(ProductDto productDto);

}
