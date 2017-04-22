package com.none.classes;

import com.none.interfaces.NumberGenerator;
import com.none.qualifiers.Loggable;
import com.none.qualifiers.ThirteenDigits;

import javax.enterprise.inject.Alternative;

@Alternative
@ThirteenDigits
public class MockGenerator implements NumberGenerator {
    @Loggable
    public String generateNumber() {
        return "MOCK!";
    }
}
