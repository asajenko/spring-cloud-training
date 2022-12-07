package pl.training.orders.domain.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import pl.training.orders.ports.input.PlaceOrderUseCase;
import pl.training.orders.ports.model.Order;
import pl.training.orders.ports.model.OrderEntry;
import pl.training.orders.ports.model.Product;
import pl.training.orders.ports.output.PaymentsService;
import pl.training.orders.ports.output.ProductsProvider;

import java.math.BigDecimal;
import java.util.Optional;

@Log
@RequiredArgsConstructor
public class PlaceOrderService implements PlaceOrderUseCase {

    private static final String DEFAULT_CURRENCY = "PLN";

    private final PaymentsService paymentsService;
    private final ProductsProvider productsProvider;
    private final DiscountCalculator discountCalculator;

    @Override
    public void place(Order order) {
        var totalValue = order.getEntries().stream()
                .map(OrderEntry::getProductId)
                .map(productsProvider::getById)
                .map(Optional::get)
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .subtract(discountCalculator.getGetValue());

        log.info("Processing new Order with value %s %s".formatted(totalValue, DEFAULT_CURRENCY));
        paymentsService.pay(totalValue, DEFAULT_CURRENCY)
                .ifPresent(payment -> log.info("Payment processed with status: " + payment));
    }

}
