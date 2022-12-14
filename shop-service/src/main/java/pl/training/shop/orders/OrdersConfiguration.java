package pl.training.shop.orders;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.training.orders.domain.service.ConstantDiscountCalculator;
import pl.training.orders.domain.service.DiscountCalculator;
import pl.training.orders.domain.service.PlaceOrderService;
import pl.training.orders.ports.input.PlaceOrderUseCase;
import pl.training.orders.ports.output.PaymentsService;
import pl.training.orders.ports.output.ProductsProvider;

import java.math.BigDecimal;

@Configuration
@Log
public class OrdersConfiguration {

    int count = 1;

    @RefreshScope
    @Bean
    public DiscountCalculator discountCalculator(@Value("${discount}") BigDecimal value) {
        log.info("Refreshing discount calculator");
        if (count == 1) {
            count++;
            return new ConstantDiscountCalculator(value);
        } else {
          throw new IllegalArgumentException();
        }
    }

    @Bean
    public PlaceOrderUseCase placeOrderUseCase(PaymentsService paymentsService, ProductsProvider productsProvider, DiscountCalculator discountCalculator) {
        return new PlaceOrderService(paymentsService, productsProvider, discountCalculator);
    }

}
