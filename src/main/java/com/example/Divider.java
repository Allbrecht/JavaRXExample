package com.example;

public class Divider {
    private int a, b;

    public Divider(int a, int b) {
        this.a = a;
        this.b = b;
    }

    double divide() throws RuntimeException {
        double tmp = (double) a / b;
        if (!Double.isFinite(tmp)) {
            throw new RuntimeException(a+", "+b);
        } else {
            return tmp;
        }
    }
}
