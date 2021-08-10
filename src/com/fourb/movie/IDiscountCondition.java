package com.fourb.movie;

public interface IDiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
