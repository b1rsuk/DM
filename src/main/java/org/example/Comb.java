package org.example;

import java.util.Arrays;

public class Comb {

    public static void genPerm(int[] A, int n) {
        int k = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (A[i] < A[i + 1]) {
                k = i;
                break;
            }
        }

        if (k == -1) {
            System.out.println("No more permutations available.");
            return;
        }

        int l = -1;
        for (int i = n - 1; i > k; i--) {
            if (A[i] > A[k]) {
                l = i;
                break;
            }
        }

        int temp = A[k];
        A[k] = A[l];
        A[l] = temp;

        Arrays.sort(A, k + 1, n);
    }
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
