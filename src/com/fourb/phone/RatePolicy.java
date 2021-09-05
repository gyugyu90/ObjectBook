package com.fourb.phone;

import com.fourb.movie.Money;

public interface RatePolicy {
    Money calculateFee(Phone phone);
}
