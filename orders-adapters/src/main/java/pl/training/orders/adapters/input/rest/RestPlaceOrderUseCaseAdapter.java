package pl.training.orders.adapters.input.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.training.orders.ports.input.PlaceOrderUseCase;

@RequestMapping("orders")
@RestController
@RequiredArgsConstructor
public class RestPlaceOrderUseCaseAdapter {

    private final PlaceOrderUseCase placeOrderUseCase;
    private final RestOrderUseCaseMapper mapper;

    @PostMapping
    public ResponseEntity<Void> place(@RequestBody OrderDto orderDto) {
        var order = mapper.toDomain(orderDto);
        placeOrderUseCase.place(order);
        return ResponseEntity.accepted().build();
    }

}
