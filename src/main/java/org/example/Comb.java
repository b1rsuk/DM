package org.example;

import java.util.Arrays;

public class Comb {
    public static int factorial(int n) {
        if (n == 0 || n == 1)
            return 1;

        return n * factorial(n - 1);
    }

    public static int A(int n, int k) {
        return factorial(n) / factorial(n - k);
    }

    public static int _A(int n, int k) {
        return (int) Math.pow(n, k);
    }

    public static int C(int n, int k) {
        return factorial(n) / (factorial(k) * factorial(n - k));
    }

    public static int _C(int n, int k) {
        return factorial(n + k - 1) / (factorial(k) * factorial(n - 1));
    }
}
