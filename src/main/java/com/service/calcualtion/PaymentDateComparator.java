package com.service.calcualtion;

import com.model.Payment;

import java.util.Comparator;

/**
 * @author Viktor Makarov
 */
public class PaymentDateComparator implements Comparator<Payment> {
    public int compare(Payment o1, Payment o2) {
        return o1.getSupplyDate().compareTo(o2.getSupplyDate());
    }
}
