package pl.training.orders.domain.service;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class DiscountCalculator {

    BigDecimal getValue;

}
