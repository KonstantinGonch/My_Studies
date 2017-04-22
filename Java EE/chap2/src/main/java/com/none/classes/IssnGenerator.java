package com.none.classes;

import com.none.interfaces.NumberGenerator;
import com.none.qualifiers.EightDigits;
import com.none.qualifiers.Loggable;

import java.util.Random;

@EightDigits
public class IssnGenerator implements NumberGenerator {
    @Loggable
    public String generateNumber() {
        return "8-" + Math.abs(new Random().nextInt());
    }
}
