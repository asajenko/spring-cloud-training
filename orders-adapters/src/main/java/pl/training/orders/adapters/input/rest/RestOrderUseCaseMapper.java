package pl.training.orders.adapters.input.rest;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.training.orders.ports.model.Order;

@Mapper(componentModel = "spring")
public interface RestOrderUseCaseMapper {

    @Mapping(source = "orderId", target = "id")
    Order toDomain(OrderDto orderDto);

}
