package pl.training.shop.payments;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.training.payments.domain.servcie.DefaultPaymentServiceFactory;
import pl.training.payments.ports.*;
import pl.training.payments.ports.input.GetPaymentUseCase;
import pl.training.payments.ports.input.ProcessPaymentUseCase;
import pl.training.payments.ports.output.PaymentReader;
import pl.training.payments.ports.output.PaymentWriter;
import pl.training.payments.ports.output.TimeProvider;

@Configuration
public class PaymentsConfiguration {

    private static final PaymentServiceFactory PAYMENT_SERVICE_FACTORY = new DefaultPaymentServiceFactory();

    @Bean
    public GetPaymentUseCase getPaymentUseCase(PaymentReader paymentReader) {
        return PAYMENT_SERVICE_FACTORY.create(paymentReader);
    }

    @Bean
    public ProcessPaymentUseCase processPaymentUseCase(PaymentWriter paymentWriter, TimeProvider timeProvider) {
        return PAYMENT_SERVICE_FACTORY.create(paymentWriter, timeProvider);
    }

}
