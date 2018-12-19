package com.colpatria.alozano.exchange.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "currency")
public class Currency implements Serializable {

    private static final long serialVersionUID = 7120603530037201586L;

    @Id
    @Column(name = "idCurrency")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    @NotNull
    private String name;

    @NotNull
    @Column(name = "active")
    private Boolean active;

    @NotNull
    @Column(name = "create_date")
    private Date createDate;

}
