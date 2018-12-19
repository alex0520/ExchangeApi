package com.colpatria.alozano.exchange.repository;

import com.colpatria.alozano.exchange.model.ExchangeRate;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Optional;

@RestResource(exported = false)
public interface ExchangeRateRepository extends PagingAndSortingRepository<ExchangeRate, Long> {
    Optional<ExchangeRate> findByFromCurrencyAndToCurrencyAndActive(Integer fromCurrency, Integer toCurrency, Boolean active);
}
