package pl.training.payments.adapters.input.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.training.payments.adapters.commons.validation.Extended;
import pl.training.payments.adapters.commons.web.LocationUri;
import pl.training.payments.ports.input.ProcessPaymentUseCase;

@RequestMapping("payments")
@RestController
@RequiredArgsConstructor
public class RestProcessPaymentUseCaseAdapter {

    private final ProcessPaymentUseCase processPaymentUseCase;
    private final RestPaymentUseCaseMapper mapper;

    @PostMapping
    public ResponseEntity<PaymentDto> process(/*@Valid*/ @Validated(Extended.class) @RequestBody PaymentRequestDto paymentRequestDto) {
        var paymentRequest = mapper.toDomain(paymentRequestDto);
        var payment = processPaymentUseCase.process(paymentRequest);
        var paymentDto = mapper.toDto(payment);
        var locationUri = LocationUri.fromRequest(paymentDto.getId());
        return ResponseEntity.created(locationUri).body(paymentDto);
    }

}
