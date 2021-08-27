package com.service.calcualtion;

import com.model.Payment;
import com.model.PaymentList;
import com.model.Result;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Date;

/**
 * @author Viktor Makarov
 */
@Component
public class CalculationImpl implements Calculation {

    public Result calculateResult(PaymentList payments, boolean isForTax, String date) {
        Date currentDate = DateConversion.getDateFromString(date);

        //If date as string is not valid - display all results
        if (currentDate == null) {
            currentDate = DateConversion.getDateFromString("9999-01-01");
        }
        Collections.sort(payments.getPayments(), new PaymentDateComparator());

        Part part;
        final Character CREDIT = 'К';
        final Character DEBIT = 'П';

        Result result = new Result();

        for (Payment p : payments.getPayments()) {

            //Sets action by part value: DEBIT - add to balance, CREDIT - subtract
            if (CREDIT.equals(Character.toUpperCase(p.getPart()))) {
                part = Part.CREDIT;
            } else if (DEBIT.equals(Character.toUpperCase(p.getPart()))) {
                part = Part.DEBIT;
            } else {
                part = Part.DEFAULT;
            }

            //Do action with balance up to date
            if (p.getSupplyDate().compareTo(currentDate) <= 0) {
                if (p.isState()){
                    result.setPercent(part.action(result.getPercent(), p.getValue()));
                }

                //Check if result for taxation
                if (isForTax) {
                    if (p.isState()) {
                        result.setBalance(part.action(result.getBalance(), p.getValue()));
                    }
                } else {
                    result.setBalance(part.action(result.getBalance(), p.getValue()));
                }
            } else break;
        }

        result.setPercent(result.getPercent() / result.getBalance() * 100);
        return result;
    }

    //Year 9999 for kinda maximum year
    public Result calculateResult(PaymentList payments, boolean isForTax) {
        return calculateResult(payments, isForTax, "9999-01-01");
    }
}
