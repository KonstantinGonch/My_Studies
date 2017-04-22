package com.none.models;

import com.none.qualifiers.ShortQuote;

@ShortQuote
public class ShortQuoteGenerator implements QuoteGenerator {
    public String generateQuote()
    {
        return "A short quote";
    }
}
