package pl.training.orders.domain.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import pl.training.orders.ports.input.PlaceOrderUseCase;
import pl.training.orders.ports.model.Order;
import pl.training.orders.ports.output.PaymentsService;

@Log
@RequiredArgsConstructor
public class PlaceOrderService implements PlaceOrderUseCase {

    private static final String DEFAULT_CURRENCY = "PLN";

    private final PaymentsService paymentsService;

    @Override
    public void place(Order order) {
        var totalValue = order.getTotalValue();
        log.info("Processing new Order with value %s %s".formatted(totalValue, DEFAULT_CURRENCY));
        paymentsService.pay(totalValue, DEFAULT_CURRENCY)
                .ifPresent(payment -> log.info("Payment processed with status: " + payment));
    }

}
