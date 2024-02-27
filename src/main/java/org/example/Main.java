package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();

        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();

        scanner.close();
        calculate(n, k);

    }

    private static void calculate(int n, int k) {
        System.out.println("Permutations: " + Comb.factorial(n));
        System.out.println("Arrangements without repetition: " + Comb.A(n, k));
        System.out.println("Arrangements with repetition: " + Comb._A(n, k));
        System.out.println("Combinations without repetition: " + Comb.C(n, k));
        System.out.println("Combinations with repetition: " + Comb._C(n, k));
    }

}