package com.colpatria.alozano.exchange.service;

import com.colpatria.alozano.exchange.model.dto.ExchangeRequestDTO;
import com.colpatria.alozano.exchange.model.dto.ExchangeResponseDTO;

public interface IExchangeRateService {
    ExchangeResponseDTO exchangeCurrency(ExchangeRequestDTO exchangeRequestDTO);

    ExchangeResponseDTO getExchangeRate(Integer fromCurrency, Integer toCurrency);
}
