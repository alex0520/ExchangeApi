package com.colpatria.alozano.exchange.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "exchange_rate")
public class ExchangeRate implements Serializable {

    private static final long serialVersionUID = 7998337927115714422L;

    @Id
    @Column(name = "idExchange_rate")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    @JoinColumn(name = "from_currency_id", referencedColumnName = "idCurrency")
    Currency fromCurrency;

    @ManyToOne
    @JoinColumn(name = "to_currency_id", referencedColumnName = "idCurrency")
    Currency toCurrency;

    @NotNull
    @Column(name = "exchange_rate")
    Double exchangeRate;

    @NotNull
    @Column(name = "active")
    private Boolean active;

    @NotNull
    @Column(name = "create_date")
    private Date createDate;
}
