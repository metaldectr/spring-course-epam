package com.epam.springcource.service;

import com.epam.springcource.model.DiscountStratedy;
import com.epam.springcource.model.Event;
import com.epam.springcource.model.User;

import java.util.List;

/**
 * Created by romario
 */
public class DiscountService {
  private List<DiscountStratedy> discounts;

  public double getDiscount(User user, Event event){
    double maxDiscount = 1;
    for (DiscountStratedy stratedy: discounts){
      double calculatedDiscount = stratedy.calculateDiscount(user, event);
      if (maxDiscount > calculatedDiscount){
        maxDiscount = calculatedDiscount;
      }
    }
    return maxDiscount;
  }

  public List<DiscountStratedy> getDiscounts() {
    return discounts;
  }

  public void setDiscounts(List<DiscountStratedy> discounts) {
    this.discounts = discounts;
  }
}
