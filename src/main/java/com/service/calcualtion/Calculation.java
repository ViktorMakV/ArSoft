package com.service.calcualtion;

import com.model.PaymentList;
import com.model.Result;

/**
 * @author Viktor Makarov
 */
public interface Calculation {
    Result calculateResult (PaymentList payments, boolean isForTax, String date);
    Result calculateResult (PaymentList payments, boolean isForTax);
}
