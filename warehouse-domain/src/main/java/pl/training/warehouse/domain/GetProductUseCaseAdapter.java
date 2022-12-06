package pl.training.warehouse.domain;

import lombok.RequiredArgsConstructor;
import pl.training.warehouse.ports.GetProductUseCase;
import pl.training.warehouse.ports.Product;

@RequiredArgsConstructor
class GetProductUseCaseAdapter implements GetProductUseCase {

    private final GetProductService getProductService;
    private final ProductDomainMapper mapper;

    @Override
    public Product getById(Long id) {
        var productDomain = getProductService.getById(id);
        return mapper.toPorts(productDomain);
    }

}
