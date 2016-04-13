package com.epam.springcource.model;

/**
 * Created by romario
 */
public interface DiscountStratedy {
    public Double calculateDiscount(User user, Event event);
}
