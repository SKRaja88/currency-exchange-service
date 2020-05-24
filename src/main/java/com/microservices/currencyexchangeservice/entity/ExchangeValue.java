package com.microservices.currencyexchangeservice.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name="Exchange_value")
public class ExchangeValue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="Exchange_From")
    private String from;

    @Column(name="Exchange_To")

    private String to;
    private BigDecimal conversionMultiple;
    private int port;

    public ExchangeValue() {
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public ExchangeValue( String from, String to, BigDecimal conversionMultiple) {

        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }
}
