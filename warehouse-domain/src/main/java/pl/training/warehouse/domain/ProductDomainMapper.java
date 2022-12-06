package pl.training.warehouse.domain;

import org.mapstruct.Mapper;
import pl.training.commons.money.FastMoneyMapper;
import pl.training.warehouse.ports.Product;

@Mapper(uses = FastMoneyMapper.class)
interface ProductDomainMapper {

    ProductDomain toDomain(Product product);

    Product toPorts(ProductDomain productDomain);

}
