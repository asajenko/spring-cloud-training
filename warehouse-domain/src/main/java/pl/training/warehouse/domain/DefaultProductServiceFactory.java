package pl.training.warehouse.domain;

import org.mapstruct.factory.Mappers;
import pl.training.warehouse.ports.GetProductUseCase;
import pl.training.warehouse.ports.ProductReader;
import pl.training.warehouse.ports.ProductServiceFactory;

public class DefaultProductServiceFactory implements ProductServiceFactory {

    private static final ProductDomainMapper MAPPER = Mappers.getMapper(ProductDomainMapper.class);

    @Override
    public GetProductUseCase create(ProductReader productReader) {
        var productReaderAdapter = new ProductReaderAdapter(productReader, MAPPER);
        var getPaymentService = new GetProductService(productReaderAdapter);
        return new GetProductUseCaseAdapter(getPaymentService, MAPPER);
    }

}
