package com.assignment.fxdeals.core.fxdeal;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
public class FxDeal {

    @Id
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

    public FxDealDto generateFxDealDto() {

        FxDealDto fxDealDto = new FxDealDto();

        fxDealDto.setId(this.id);
        fxDealDto.setFromCurrency(this.fromCurrency);
        fxDealDto.setToCurrency(this.toCurrency);
        fxDealDto.setTimestamp(this.timestamp);
        fxDealDto.setAmount(this.amount);

        return fxDealDto;
    }

}
