package com.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * @author Viktor Makarov
 */
@XmlRootElement
public class Payment {
    private String name;
    private Date supplyDate;
    private boolean state;
    private char part;
    private long value;

    public Payment() {
    }

    public Payment(String name, Date supplyDate, boolean state, char part, long value) {
        this.name = name;
        this.supplyDate = supplyDate;
        this.state = state;
        this.part = part;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getSupplyDate() {
        return supplyDate;
    }

    public void setSupplyDate(Date supplyDate) {
        this.supplyDate = supplyDate;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public char getPart() {
        return part;
    }

    public void setPart(char part) {
        this.part = part;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
