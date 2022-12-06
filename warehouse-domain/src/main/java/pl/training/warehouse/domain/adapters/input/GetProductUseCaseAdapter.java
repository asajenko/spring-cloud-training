package pl.training.warehouse.domain.adapters.input;

import lombok.RequiredArgsConstructor;
import pl.training.warehouse.domain.adapters.ProductDomainMapper;
import pl.training.warehouse.domain.service.GetProductService;
import pl.training.warehouse.ports.input.GetProductUseCase;
import pl.training.warehouse.ports.model.Product;

@RequiredArgsConstructor
public class GetProductUseCaseAdapter implements GetProductUseCase {

    private final GetProductService getProductService;
    private final ProductDomainMapper mapper;

    @Override
    public Product getById(Long id) {
        var productDomain = getProductService.getById(id);
        return mapper.toPorts(productDomain);
    }

}
