package com.service.calcualtion;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author Viktor Makarov
 */
public class DateConversion {
    public static Date getDateFromString(String stringDate) {
        String[] dateValues = stringDate.split("-");
        if (dateValues.length < 3) {
            return null;
        }

        int[] dateValuesAsInt = new int[dateValues.length];
        try {
            if (dateValues[0] != null && Integer.parseInt(dateValues[0]) < 100) {
                dateValues[0] = "20" + dateValues[0];
            }

            for (int i = 0; i < dateValues.length; i++) {
                if (dateValues[i] != null) {
                    dateValuesAsInt[i] = Integer.parseInt(dateValues[i]);
                }
            }
        } catch (NumberFormatException e) {
            return null;
        }

        Calendar calendar = new GregorianCalendar();
        calendar.set(dateValuesAsInt[0], dateValuesAsInt[1] - 1, dateValuesAsInt[2], 1, 0, 0);
        return new Date(calendar.getTimeInMillis());
    }
}
