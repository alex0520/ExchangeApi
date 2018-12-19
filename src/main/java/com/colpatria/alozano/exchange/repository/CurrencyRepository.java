package com.colpatria.alozano.exchange.repository;

import com.colpatria.alozano.exchange.model.Currency;
import com.colpatria.alozano.exchange.model.ExchangeRate;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RestResource(exported = false)
@Repository
public interface CurrencyRepository extends BaseRepository<Currency, Integer> {

}
