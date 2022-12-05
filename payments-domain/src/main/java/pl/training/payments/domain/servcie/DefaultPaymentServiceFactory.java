package pl.training.payments.domain.servcie;

import org.mapstruct.factory.Mappers;
import pl.training.payments.domain.adapters.PaymentDomainMapper;
import pl.training.payments.domain.adapters.input.GetPaymentUseCaseAdapter;
import pl.training.payments.domain.adapters.input.ProcessPaymentUseCaseAdapter;
import pl.training.payments.domain.adapters.output.PaymentReaderAdapter;
import pl.training.payments.domain.adapters.output.PaymentWriterAdapter;
import pl.training.payments.ports.PaymentServiceFactory;
import pl.training.payments.ports.input.GetPaymentUseCase;
import pl.training.payments.ports.input.ProcessPaymentUseCase;
import pl.training.payments.ports.output.PaymentReader;
import pl.training.payments.ports.output.PaymentWriter;
import pl.training.payments.ports.output.TimeProvider;

public class DefaultPaymentServiceFactory implements PaymentServiceFactory {

    private static final PaymentDomainMapper MAPPER = Mappers.getMapper(PaymentDomainMapper.class);
    private static final PaymentIdGenerator PAYMENT_ID_GENERATOR = new UuidPaymentIdGenerator();
    private static final PaymentFeeCalculator PAYMENT_FEE_CALCULATOR = new PercentagePaymentFeeCalculator(0.01);

    @Override
    public GetPaymentUseCase create(PaymentReader paymentReader) {
        var paymentReaderAdapter = new PaymentReaderAdapter(paymentReader, MAPPER);
        var getPaymentService = new GetPaymentService(paymentReaderAdapter);
        return new GetPaymentUseCaseAdapter(getPaymentService, MAPPER);
    }

    @Override
    public ProcessPaymentUseCase create(PaymentWriter paymentWriter, TimeProvider timeProvider) {
        var paymentWriterAdapter = new PaymentWriterAdapter(paymentWriter, MAPPER);
        var processPaymentService = new ProcessPaymentService(PAYMENT_ID_GENERATOR, PAYMENT_FEE_CALCULATOR, paymentWriterAdapter, timeProvider);
        return new ProcessPaymentUseCaseAdapter(processPaymentService, MAPPER);
    }

}
