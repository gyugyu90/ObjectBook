package com.fourb.movie;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
