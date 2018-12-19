package com.colpatria.alozano.exchange.controller;

import com.colpatria.alozano.exchange.model.dto.ExchangeRequestDTO;
import com.colpatria.alozano.exchange.model.dto.ExchangeResponseDTO;
import com.colpatria.alozano.exchange.service.IExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
public class ExchangeController {

    @Autowired
    IExchangeRateService exchangeRateService;

    @PostMapping(path = "/api/exchange")
    public ResponseEntity<ExchangeResponseDTO> register(@Valid @RequestBody ExchangeRequestDTO exchangeRequestDTO) throws Exception {

        return ResponseEntity.ok(exchangeRateService.exchangeCurrency(exchangeRequestDTO));
    }
}
