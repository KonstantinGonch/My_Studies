package com.none.classes;

import com.none.interfaces.NumberGenerator;
import com.none.qualifiers.Loggable;
import com.none.qualifiers.ThirteenDigits;

import java.util.Random;

@ThirteenDigits
public class IsbnGenerator implements NumberGenerator {
    @Loggable
    public String generateNumber() {
        return "13-84356-"+Math.abs(new Random().nextInt());
    }
}
