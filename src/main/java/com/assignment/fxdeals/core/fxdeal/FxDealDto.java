package com.assignment.fxdeals.core.fxdeal;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class FxDealDto {

    private String id;

    private String fromCurrency;
    private String toCurrency;
    private Timestamp timestamp;
    private BigDecimal amount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public Timestamp getTimestamp() {
        if (timestamp == null) {
            return null;
        }
        return new Timestamp(timestamp.getTime());
    }

    public void setTimestamp(Timestamp timestamp) {
        if (timestamp == null) {
            this.timestamp = null;
        } else {
            this.timestamp = new Timestamp(timestamp.getTime());
        }
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public FxDeal generateEntity() {

        FxDeal fxDeal = new FxDeal();

        fxDeal.setId(this.id);
        fxDeal.setFromCurrency(this.fromCurrency);
        fxDeal.setToCurrency(this.toCurrency);
        fxDeal.setTimestamp(this.timestamp);
        fxDeal.setAmount(this.amount);

        return fxDeal;
    }

    public boolean validate() {
        if (this.id != null && this.fromCurrency != null
            && this.toCurrency != null && this.timestamp != null
            && this.amount != null) {
            return true;
        }
        return false;
    }

}
