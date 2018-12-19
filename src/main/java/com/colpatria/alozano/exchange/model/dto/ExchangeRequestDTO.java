package com.colpatria.alozano.exchange.model.dto;

import com.colpatria.alozano.exchange.validation.annotation.ValidCurrency;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Data
public class ExchangeRequestDTO {
    @NotNull(message = "The from currency must not be null")
    @ValidCurrency(message = "The from currency must be a valid currency")
    private Integer fromCurrency;

    @NotNull(message = "The to currency must not be null")
    @ValidCurrency(message = "The to currency must be a valid currency")
    private Integer toCurrency;

    @NotNull(message = "The value to convert must not be null")
    @PositiveOrZero(message = "Should be greater or equals than zero")
    private Double value;


}
