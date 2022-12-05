package pl.training.payments.ports;

import pl.training.payments.ports.input.GetPaymentUseCase;
import pl.training.payments.ports.input.ProcessPaymentUseCase;
import pl.training.payments.ports.output.PaymentReader;
import pl.training.payments.ports.output.PaymentWriter;
import pl.training.payments.ports.output.TimeProvider;

public interface PaymentServiceFactory {

    GetPaymentUseCase create(PaymentReader paymentReader);

    ProcessPaymentUseCase create(PaymentWriter paymentWriter, TimeProvider timeProvider);

}
