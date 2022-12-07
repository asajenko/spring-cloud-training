package pl.training.warehouse.adapters.output.events;

import org.mapstruct.Mapper;
import pl.training.warehouse.ports.model.ProductEvent;

@Mapper(componentModel = "spring")
public interface EventsProductMapper {

    ProductEventMessage toMessage(ProductEvent event);

}
