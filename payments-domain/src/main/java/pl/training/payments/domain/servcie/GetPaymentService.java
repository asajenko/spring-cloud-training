package pl.training.payments.domain.servcie;

import lombok.RequiredArgsConstructor;
import pl.training.payments.domain.model.PaymentDomain;
import pl.training.payments.domain.model.PaymentStatusDomain;
import pl.training.payments.ports.model.Page;
import pl.training.payments.ports.model.PaymentNotFoundException;
import pl.training.payments.ports.model.ResultPage;

@RequiredArgsConstructor
public class GetPaymentService {

    private final PaymentDomainReader paymentReader;

    public PaymentDomain getById(String id) {
        return paymentReader.getById(id)
                .orElseThrow(PaymentNotFoundException::new);
    }

    public ResultPage<PaymentDomain> getByStatus(PaymentStatusDomain status, Page page) {
        return paymentReader.getByStatus(status, page);
    }

}
