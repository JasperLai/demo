package com.example.demo.model.Report.type;


public class ExactNText {
    private final int N;
    private final String value;

    public ExactNText(int N, String text) {
        if (N <= 0) {
            throw new IllegalArgumentException("N must be greater than 0");
        }

        if (text == null) {
            throw new IllegalArgumentException("Input text cannot be null");
        }

        if (text.length() > N) {
            this.value = text.substring(0, N);
        } else {
            StringBuilder sb = new StringBuilder(text);
            while (sb.length() < N) {
                sb.append(" ");
            }
            this.value = sb.toString();
        }

        this.N = N;
    }

    @Override
    public String toString() {
        return value;
    }

    public int getN() {
        return N;
    }

}

