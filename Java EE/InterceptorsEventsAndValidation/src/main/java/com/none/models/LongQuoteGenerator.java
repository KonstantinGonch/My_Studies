package com.none.models;

import com.none.qualifiers.LongQuote;

@LongQuote
public class LongQuoteGenerator implements QuoteGenerator{
    public String generateQuote() {
        return "A very long quote";
    }
}
