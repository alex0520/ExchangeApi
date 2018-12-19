package com.colpatria.alozano.exchange.service;

public interface IExchangeRateService {
    Double changeCurrency(Integer fromCurrency, Integer toCurrency, Double value);
}
