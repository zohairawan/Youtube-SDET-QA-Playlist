package org.example.tests.datepickers;

import java.time.Month;
import java.util.HashMap;
import java.util.Map;

public class DatePickers2UtilTest {

    public static Month convertMonth(String month) {
        Map<String, Month> monthMap = new HashMap<>();
        monthMap.put("Jan", Month.JANUARY);
        monthMap.put("Feb", Month.FEBRUARY);
        monthMap.put("Mar", Month.MARCH);
        monthMap.put("Apr", Month.APRIL);
        monthMap.put("May", Month.MAY);
        monthMap.put("Jun", Month.JUNE);
        monthMap.put("Jul", Month.JULY);
        monthMap.put("Aug", Month.AUGUST);
        monthMap.put("Sep", Month.SEPTEMBER);
        monthMap.put("Oct", Month.OCTOBER);
        monthMap.put("Nov", Month.NOVEMBER);
        monthMap.put("Dec", Month.DECEMBER);

        return monthMap.get(month);
    }
}
