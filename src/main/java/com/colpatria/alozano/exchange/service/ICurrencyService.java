package com.colpatria.alozano.exchange.service;

import com.colpatria.alozano.exchange.model.Currency;

import java.util.Optional;

public interface ICurrencyService {
    Optional<Currency> findById(Integer id);
}
