package pl.training.warehouse.domain.adapters;

import org.mapstruct.Mapper;
import pl.training.commons.money.FastMoneyMapper;
import pl.training.warehouse.domain.model.ProductDomain;
import pl.training.warehouse.ports.model.Product;

@Mapper(uses = FastMoneyMapper.class)
public interface ProductDomainMapper {

    ProductDomain toDomain(Product product);

    Product toPorts(ProductDomain productDomain);

}
