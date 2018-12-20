package com.colpatria.alozano.exchange.controller;

import com.colpatria.alozano.exchange.model.dto.ExchangeRequestDTO;
import com.colpatria.alozano.exchange.model.dto.ExchangeResponseDTO;
import com.colpatria.alozano.exchange.service.IExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ExchangeController {

    @Autowired
    IExchangeRateService exchangeRateService;

    @PostMapping(path = "/api/exchange")
    public ResponseEntity<ExchangeResponseDTO> register(@Valid @RequestBody ExchangeRequestDTO exchangeRequestDTO) {

        return ResponseEntity.ok(exchangeRateService.exchangeCurrency(exchangeRequestDTO));
    }

    @GetMapping(value = "/api/exchange")
    public ResponseEntity<ExchangeResponseDTO> getBarBySimplePathWithRequestParam(
            @RequestParam("fromCurrency") Integer fromCurrency, @RequestParam("toCurrency") Integer toCurrency) {
        return ResponseEntity.ok(exchangeRateService.getExchangeRate(fromCurrency, toCurrency));
    }
}
