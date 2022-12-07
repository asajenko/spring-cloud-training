package pl.training.shop.orders;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.training.orders.domain.service.DiscountCalculator;
import pl.training.orders.domain.service.PlaceOrderService;
import pl.training.orders.ports.input.PlaceOrderUseCase;
import pl.training.orders.ports.output.PaymentsService;
import pl.training.orders.ports.output.ProductsProvider;

import java.math.BigDecimal;

@Configuration
@Log
public class OrdersConfiguration {

    @RefreshScope
    @Bean
    public DiscountCalculator discountCalculator(@Value("discount")BigDecimal value) {
        log.info("Refreshing discount calculator");
        return new DiscountCalculator(value);
    }

    @Bean
    public PlaceOrderUseCase placeOrderUseCase(PaymentsService paymentsService, ProductsProvider productsProvider, DiscountCalculator discountCalculator) {
        return new PlaceOrderService(paymentsService, productsProvider, discountCalculator);
    }

}
