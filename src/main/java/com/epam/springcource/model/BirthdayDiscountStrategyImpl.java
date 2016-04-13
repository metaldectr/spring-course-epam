package com.epam.springcource.model;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by romario
 */
public class BirthdayDiscountStrategyImpl implements DiscountStratedy {
    private double discountValue;

    public Double calculateDiscount(User user, Event event) {
        Calendar userBirthdayCalendar = GregorianCalendar.getInstance();
        userBirthdayCalendar.setTime(user.getBirthday());
        Calendar eventCalendar = GregorianCalendar.getInstance();
        eventCalendar.setTime(event.getTime());
        if (eventCalendar.get(Calendar.MONTH) == userBirthdayCalendar.get(Calendar.MONTH) &&
                eventCalendar.get(Calendar.DAY_OF_MONTH) == userBirthdayCalendar.get(Calendar.DAY_OF_MONTH)) {
            return discountValue;
        }
        return Double.valueOf(1);
    }

    public void setDiscountValue(double discountValue) {
        this.discountValue = discountValue;
    }
}
