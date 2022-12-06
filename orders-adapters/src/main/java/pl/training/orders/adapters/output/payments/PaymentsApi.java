package pl.training.orders.adapters.output.payments;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("PAYMENTS-SERVICE")
public interface PaymentsApi {

    @PostMapping("payments")
    PaymentDto process(@RequestBody PaymentRequestDto paymentRequestDto);

}
