package com.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Viktor Makarov
 */
@XmlRootElement
public class PaymentList {
    private List<Payment> payments;

    public PaymentList(List<Payment> payments) {
        this.payments = payments;
    }

    public PaymentList() {
        payments = new ArrayList<Payment>();
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
}
