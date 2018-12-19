package com.colpatria.alozano.exchange.service.impl;

import com.colpatria.alozano.exchange.model.ExchangeRate;
import com.colpatria.alozano.exchange.repository.ExchangeRateRepository;
import com.colpatria.alozano.exchange.service.IExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExchangeRateService implements IExchangeRateService {
    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    @Override
    public Double changeCurrency(Integer fromCurrency, Integer toCurrency, Double value) {
        Optional<ExchangeRate> exchangeRate = exchangeRateRepository.findByFromCurrencyAndToCurrencyAndActive(fromCurrency, toCurrency, Boolean.TRUE);
        return null;
    }
}
