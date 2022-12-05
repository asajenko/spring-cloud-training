package pl.training.payments.adapters.input.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.training.payments.adapters.commons.web.ResultPageDto;
import pl.training.payments.ports.input.GetPaymentUseCase;
import pl.training.payments.ports.model.Page;

import static pl.training.payments.ports.model.PaymentStatus.CONFIRMED;

@RequestMapping("api/payments")
@RestController
@RequiredArgsConstructor
public class RestGetPaymentUseCaseAdapter {

    private final GetPaymentUseCase getPaymentUseCase;
    private final RestPaymentUseCaseMapper mapper;

    @GetMapping("{id}")
    public ResponseEntity<PaymentDto> getById(@PathVariable String id) {
        var payment = getPaymentUseCase.getById(id);
        var paymentDto = mapper.toDto(payment);
        return ResponseEntity.ok(paymentDto);
    }

    @GetMapping("confirmed")
    public ResponseEntity<ResultPageDto<PaymentDto>> getConfirmedPayments(
            @RequestParam(required = false, defaultValue = "0") int pageNumber,
            @RequestParam(required = false, defaultValue = "5") int pageSize) {
        var page = new Page(pageNumber, pageSize);
        var resultPage = getPaymentUseCase.getByStatus(CONFIRMED, page);
        var resultPageDto = mapper.toDto(resultPage);
        return ResponseEntity.ok(resultPageDto);
    }

}
