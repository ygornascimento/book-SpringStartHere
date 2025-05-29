package com.example.springstartherechapter12.model;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

public class Account {
    @Id // We annotate the attribute that models the primary key with the @Id annotation.
    private long id;
    private String name;
    private BigDecimal amount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
