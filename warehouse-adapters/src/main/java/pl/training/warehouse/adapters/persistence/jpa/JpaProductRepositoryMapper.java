package pl.training.warehouse.adapters.persistence.jpa;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.training.warehouse.ports.Product;

@Mapper(componentModel = "spring")
public interface JpaProductRepositoryMapper {

    @Mapping(source = "price", target = "value")
    ProductEntity toEntity(Product product);

    @Mapping(source = "value", target = "price")
    Product toDomain(ProductEntity entity);

}
