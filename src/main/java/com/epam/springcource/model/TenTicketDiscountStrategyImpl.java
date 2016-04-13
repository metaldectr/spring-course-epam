package com.epam.springcource.model;

/**
 * Created by romario
 */
public class TenTicketDiscountStrategyImpl implements DiscountStratedy {
    private double discountValue;

    public Double calculateDiscount(User user, Event event) {
        if (user.getBookedTickets().size() != 0 && user.getBookedTickets().size() % 9 == 0) {
            return discountValue;
        }
        return Double.valueOf(1);
    }

    public void setDiscountValue(double discountValue) {
        this.discountValue = discountValue;
    }
}
