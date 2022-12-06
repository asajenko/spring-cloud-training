package pl.training.warehouse.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class GetProductService {

    private final ProductReaderAdapter productReader;

    ProductDomain getById(Long id) {
        return productReader.getById(id)
                .orElseThrow(IllegalArgumentException::new);
    }

}
