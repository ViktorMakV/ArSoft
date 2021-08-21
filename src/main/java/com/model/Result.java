package com.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Viktor Makarov
 */
@XmlRootElement
public class Result {
    private final float INTEREST_RATE = 0.13F;
    private long balance;
    private float percent;

    public Result() {
    }

    public Result(long balance, float percent) {
        this.balance = balance;
        this.percent = percent;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }
}
