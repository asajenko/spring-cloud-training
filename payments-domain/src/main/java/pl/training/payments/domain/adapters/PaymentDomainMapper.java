package pl.training.payments.domain.adapters;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import pl.training.commons.money.FastMoneyMapper;
import pl.training.payments.domain.model.PaymentDomain;
import pl.training.payments.domain.model.PaymentRequestDomain;
import pl.training.payments.domain.model.PaymentStatusDomain;
import pl.training.payments.ports.model.Payment;
import pl.training.payments.ports.model.PaymentRequest;
import pl.training.payments.ports.model.PaymentStatus;
import pl.training.payments.ports.model.ResultPage;

import java.util.List;

@Mapper(uses = FastMoneyMapper.class)
public interface PaymentDomainMapper {

    PaymentDomain toDomain(Payment payment);

    Payment toPorts(PaymentDomain paymentDomain);

    PaymentRequestDomain toDomain(PaymentRequest paymentRequest);

    PaymentStatus toPorts(PaymentStatusDomain paymentStatusDomain);

    PaymentStatusDomain toDomain(PaymentStatus paymentStatus);

    @IterableMapping(elementTargetType = PaymentDomain.class)
    List<PaymentDomain> toDomain(List<Payment> payments);

    ResultPage<Payment> toPorts(ResultPage<PaymentDomain> paymentDomainResultPage);

    ResultPage<PaymentDomain> toDomain(ResultPage<Payment> paymentResultPage);

}
