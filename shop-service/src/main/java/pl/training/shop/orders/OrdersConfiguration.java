package pl.training.shop.orders;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.training.orders.domain.service.PlaceOrderService;
import pl.training.orders.ports.input.PlaceOrderUseCase;
import pl.training.orders.ports.output.PaymentsService;
import pl.training.orders.ports.output.ProductsProvider;

@Configuration
public class OrdersConfiguration {

    @Bean
    public PlaceOrderUseCase placeOrderUseCase(PaymentsService paymentsService, ProductsProvider productsProvider) {
        return new PlaceOrderService(paymentsService, productsProvider);
    }

}
