package com.colpatria.alozano.exchange.repository;

import com.colpatria.alozano.exchange.model.ExchangeRate;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RestResource(exported = false)
@Repository
public interface ExchangeRateRepository extends BaseRepository<ExchangeRate, Integer> {
    Optional<ExchangeRate> findByFromCurrencyIdAndToCurrencyIdAndActive(Integer fromCurrency, Integer toCurrency, Boolean active);
}
