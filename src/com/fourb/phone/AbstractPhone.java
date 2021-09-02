package com.fourb.phone;

import com.fourb.movie.Money;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPhone {

    private List<Call> calls = new ArrayList<>();


    public Money calculateFee() {
        Money result = Money.ZERO;

        for(Call call: calls) {
            result = result.plus(calculateCallFee(call));
        }

        return result;
    }

    protected abstract Money calculateCallFee(Call call);

}
