package com.colpatria.alozano.exchange.validation.validator;

import com.colpatria.alozano.exchange.service.ICurrencyService;
import com.colpatria.alozano.exchange.validation.annotation.ValidCurrency;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CurrencyValidator implements ConstraintValidator<ValidCurrency, Integer> {

    @Autowired
    ICurrencyService currencyService;

    @Override
    public void initialize(ValidCurrency constraintAnnotation) {

    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {

        return value != null && currencyService.findById(value) != null;

    }
}
