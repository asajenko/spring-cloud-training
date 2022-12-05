package pl.training.payments.domain.adapters.output;

import lombok.RequiredArgsConstructor;
import pl.training.payments.domain.adapters.PaymentDomainMapper;
import pl.training.payments.domain.model.PaymentDomain;
import pl.training.payments.domain.model.PaymentStatusDomain;
import pl.training.payments.domain.servcie.PaymentDomainReader;
import pl.training.payments.ports.model.Page;
import pl.training.payments.ports.model.ResultPage;
import pl.training.payments.ports.output.PaymentReader;

import java.util.Optional;

@RequiredArgsConstructor
public class PaymentReaderAdapter implements PaymentDomainReader {

    private final PaymentReader paymentReader;
    private final PaymentDomainMapper mapper;

    @Override
    public Optional<PaymentDomain> getById(String id) {
        return paymentReader.getById(id)
                .map(mapper::toDomain);
    }

    @Override
    public ResultPage<PaymentDomain> getByStatus(PaymentStatusDomain status, Page page) {
        var paymentStatus = mapper.toPorts(status);
        return mapper.toDomain(paymentReader.getByStatus(paymentStatus, page));
    }

}
