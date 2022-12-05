package pl.training.payments.domain.servcie;

import lombok.RequiredArgsConstructor;
import org.javamoney.moneta.FastMoney;
import pl.training.payments.domain.model.PaymentDomain;
import pl.training.payments.domain.model.PaymentRequestDomain;
import pl.training.payments.domain.model.PaymentStatusDomain;
import pl.training.payments.ports.output.TimeProvider;

@RequiredArgsConstructor
public class ProcessPaymentService {

    private static final PaymentStatusDomain DEFAULT_PAYMENT_STATUS = PaymentStatusDomain.CONFIRMED;

    private final PaymentIdGenerator paymentIdGenerator;
    private final PaymentFeeCalculator paymentFeeCalculator;
    private final PaymentDomainWriter paymentWriter;
    private final TimeProvider timeProvider;

    public PaymentDomain process(PaymentRequestDomain paymentRequestDomain) {
        var paymentValue = calculatePaymentValue(paymentRequestDomain.getValue());
        var payment = createPayment(paymentValue);
        return paymentWriter.save(payment);
    }

    private PaymentDomain createPayment(FastMoney paymentValue) {
        return PaymentDomain.builder()
                .id(paymentIdGenerator.getNext())
                .value(paymentValue)
                .timestamp(timeProvider.getTimestamp())
                .status(DEFAULT_PAYMENT_STATUS)
                .build();
    }

    private FastMoney calculatePaymentValue(FastMoney paymentValue) {
        return paymentValue.add(paymentFeeCalculator.calculateFee(paymentValue));
    }

}
