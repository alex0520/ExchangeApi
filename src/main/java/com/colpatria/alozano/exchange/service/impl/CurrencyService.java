package com.colpatria.alozano.exchange.service.impl;

import com.colpatria.alozano.exchange.model.Currency;
import com.colpatria.alozano.exchange.model.ExchangeRate;
import com.colpatria.alozano.exchange.repository.CurrencyRepository;
import com.colpatria.alozano.exchange.repository.ExchangeRateRepository;
import com.colpatria.alozano.exchange.service.ICurrencyService;
import com.colpatria.alozano.exchange.service.IExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CurrencyService implements ICurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;


    @Override
    public Optional<Currency> findById(Integer id) {
        return currencyRepository.findById(id);
    }
}
