package com.example.demo.model.Report.type;


public class MaxNText {
    
    private final int N;
    private final String value;

    public MaxNText(int N, String text) {
        if (N <= 0) {
            throw new IllegalArgumentException("N must be greater than 0");
        }

        if (text == null) {
            throw new IllegalArgumentException("Input text cannot be null");
        }

        this.N = N;
        this.value = text.length() > N ? text.substring(0, N) : text;
    }

    @Override
    public String toString() {
        return value;
    }

    public int getN() {
        return N;
    }
}
