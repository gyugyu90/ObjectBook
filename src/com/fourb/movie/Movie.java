package com.fourb.movie;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class Movie {

    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;
    private DiscountPolicy discountPolicy;

    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;

    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }


    public MovieType getMovieType() {
        return movieType;
    }

    public Money calculateAmountDiscountedFee() {
        if (movieType != MovieType.AMOUNT_DISCOUNT) {
            throw new IllegalArgumentException();
        }

        return fee.minus(discountAmount);
    }

    public Money calculatePercentDiscountedFee() {
        if (movieType != MovieType.PERCENT_DISCOUNT) {
            throw new IllegalArgumentException();
        }

        return fee.minus(fee.times(discountPercent));
    }

    public Money calculateNoneDiscountedFee() {
        if (movieType != MovieType.NONE_DISCOUNT) {
            throw new IllegalArgumentException();
        }

        return fee;
    }

    public boolean isDiscountable(LocalDateTime whenScreened, int sequence) {
        for (DiscountCondition condition : discountConditions) {
            if (condition.getType() == DiscountConditionType.PERIOD) {
                if (condition.isDiscountable(whenScreened.getDayOfWeek(), whenScreened.toLocalTime())) {
                    return true;
                }
            } else {
                if (condition.isDiscountable(sequence)) {
                    return true;
                }
            }
        }

        return false;
    }


    public Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening) {
        // discountPolicy에 calculateDiscountAmount 메시지를 전송해 할인 요금을 반환받는다.
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }

    public void setFee(Money fee) {
        this.fee = fee;
    }

    public List<DiscountCondition> getDiscountConditions() {
        return discountConditions;
    }

    public void setDiscountConditions(List<DiscountCondition> discountConditions) {
        this.discountConditions = discountConditions;
    }

    public void setMovieType(MovieType movieType) {
        this.movieType = movieType;
    }

    public Money getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Money discountAmount) {
        this.discountAmount = discountAmount;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

}
