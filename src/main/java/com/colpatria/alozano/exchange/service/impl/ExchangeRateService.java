package com.colpatria.alozano.exchange.service.impl;

import com.colpatria.alozano.exchange.exception.ExchangeException;
import com.colpatria.alozano.exchange.model.ExchangeRate;
import com.colpatria.alozano.exchange.model.dto.ExchangeRequestDTO;
import com.colpatria.alozano.exchange.model.dto.ExchangeResponseDTO;
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
    public ExchangeResponseDTO exchangeCurrency(ExchangeRequestDTO exchangeRequestDTO) {
        Optional<ExchangeRate> exchangeRate = exchangeRateRepository.findByFromCurrencyIdAndToCurrencyIdAndActive(exchangeRequestDTO.getFromCurrency(), exchangeRequestDTO.getToCurrency(), Boolean.TRUE);
        if(!exchangeRate.isPresent()){
            throw new ExchangeException("There is not exchange rate configured to that currencies");
        }

        Double exchangedValue = exchangeRequestDTO.getValue() * exchangeRate.get().getExchangeRate();
        ExchangeResponseDTO exchangeResponseDTO = new ExchangeResponseDTO();
        exchangeResponseDTO.setValue(exchangedValue);

        return exchangeResponseDTO;
    }

    @Override
    public ExchangeResponseDTO getExchangeRate(Integer fromCurrency, Integer toCurrency) {
        Optional<ExchangeRate> exchangeRate = exchangeRateRepository.findByFromCurrencyIdAndToCurrencyIdAndActive(fromCurrency, toCurrency, Boolean.TRUE);
        if(!exchangeRate.isPresent()){
            throw new ExchangeException("There is not exchange rate configured to that currencies");
        }

        ExchangeResponseDTO exchangeResponseDTO = new ExchangeResponseDTO();
        exchangeResponseDTO.setValue(exchangeRate.get().getExchangeRate());

        return exchangeResponseDTO;
    }
}
