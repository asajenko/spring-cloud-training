package pl.training.shop.payments;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.training.payments.ports.input.GetPaymentUseCase;
import pl.training.payments.ports.input.ProcessPaymentUseCase;
import pl.training.payments.ports.model.*;

//@Primary
//@Transactional
//@Service
@RequiredArgsConstructor
public class TransactionalPaymentsFacade implements GetPaymentUseCase, ProcessPaymentUseCase {

    private final ProcessPaymentUseCase processPaymentUseCase;
    private final GetPaymentUseCase getPaymentUseCase;

    @Override
    public Payment getById(String id) {
        return getPaymentUseCase.getById(id);
    }

    @Override
    public ResultPage<Payment> getByStatus(PaymentStatus status, Page page) {
        return getPaymentUseCase.getByStatus(status, page);
    }

    @Override
    public Payment process(PaymentRequest paymentRequest) {
        return processPaymentUseCase.process(paymentRequest);
    }

}
