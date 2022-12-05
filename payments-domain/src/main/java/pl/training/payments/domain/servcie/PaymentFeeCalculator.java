package pl.training.payments.domain.servcie;

import org.javamoney.moneta.FastMoney;

interface PaymentFeeCalculator {

    FastMoney calculateFee(FastMoney paymentValue);

}
