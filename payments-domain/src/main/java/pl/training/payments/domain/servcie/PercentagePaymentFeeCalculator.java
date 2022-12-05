package pl.training.payments.domain.servcie;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.javamoney.moneta.FastMoney;
import pl.training.payments.domain.servcie.PaymentFeeCalculator;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class PercentagePaymentFeeCalculator implements PaymentFeeCalculator {

    private final double percentage;

    @Override
    public FastMoney calculateFee(FastMoney paymentValue) {
        return paymentValue.multiply(percentage);
    }

}
