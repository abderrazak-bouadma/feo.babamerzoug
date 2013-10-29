package com.babamerzoug.feo.domain;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: merzoug
 * Date: 10/29/13
 * Time: 5:07 PM
 */
public class Rate {

    @Id
    private String id;
    private Date timestamp;
    private double buyRate;
    private double saleRate;
    private String currencyExchangeDeskId;
    private String maintainerId;
    private int upvotes;
    private int downvotes;

    public Rate() {
    }

    public Rate(Date timestamp, double buyRate, double saleRate, String currencyExchangeDeskId, String maintainerId) {
        this.timestamp = timestamp;
        this.buyRate = buyRate;
        this.saleRate = saleRate;
        this.currencyExchangeDeskId = currencyExchangeDeskId;
        this.maintainerId = maintainerId;
    }

    @Override
    public String toString() {
        return "Rate{" +
                "id='" + id + '\'' +
                ", timestamp=" + timestamp +
                ", buyRate=" + buyRate +
                ", saleRate=" + saleRate +
                ", currencyExchangeDeskId='" + currencyExchangeDeskId + '\'' +
                ", maintainerId='" + maintainerId + '\'' +
                ", upvotes=" + upvotes +
                ", downvotes=" + downvotes +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public double getBuyRate() {
        return buyRate;
    }

    public void setBuyRate(double buyRate) {
        this.buyRate = buyRate;
    }

    public double getSaleRate() {
        return saleRate;
    }

    public void setSaleRate(double saleRate) {
        this.saleRate = saleRate;
    }

    public String getCurrencyExchangeDeskId() {
        return currencyExchangeDeskId;
    }

    public void setCurrencyExchangeDeskId(String currencyExchangeDeskId) {
        this.currencyExchangeDeskId = currencyExchangeDeskId;
    }

    public String getMaintainerId() {
        return maintainerId;
    }

    public void setMaintainerId(String maintainerId) {
        this.maintainerId = maintainerId;
    }

    public int getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(int upvotes) {
        this.upvotes = upvotes;
    }

    public int getDownvotes() {
        return downvotes;
    }

    public void setDownvotes(int downvotes) {
        this.downvotes = downvotes;
    }
}
