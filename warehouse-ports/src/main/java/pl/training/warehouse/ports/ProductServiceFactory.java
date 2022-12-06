package pl.training.warehouse.ports;

public interface ProductServiceFactory {

    GetProductUseCase create(ProductReader productReader);

}
