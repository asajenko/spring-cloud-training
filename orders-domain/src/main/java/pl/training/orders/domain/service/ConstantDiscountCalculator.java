package pl.training.orders.domain.service;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class ConstantDiscountCalculator implements DiscountCalculator {

    BigDecimal getValue;

}
