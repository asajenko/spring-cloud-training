package pl.training.payments.domain.servcie;

import pl.training.payments.domain.model.PaymentDomain;
import pl.training.payments.domain.model.PaymentStatusDomain;
import pl.training.payments.ports.model.Page;
import pl.training.payments.ports.model.ResultPage;

import java.util.Optional;

public interface PaymentDomainReader {

    Optional<PaymentDomain> getById(String id);

    ResultPage<PaymentDomain> getByStatus(PaymentStatusDomain status, Page page);

}
