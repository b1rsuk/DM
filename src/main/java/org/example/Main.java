package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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

        List<Integer> permutation = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        System.out.println("genPerm");
        CombinatorialGenerator.genPerm(permutation);
        System.out.println("genComb");
        CombinatorialGenerator.genComb(permutation, 4, 6);
        System.out.println(permutation);

    }

    private static void calculate(int n, int k) {
        System.out.println("Permutations: " + Comb.factorial(n));
        System.out.println("Arrangements without repetition: " + Comb.A(n, k));
        System.out.println("Arrangements with repetition: " + Comb._A(n, k));
        System.out.println("Combinations without repetition: " + Comb.C(n, k));
        System.out.println("Combinations with repetition: " + Comb._C(n, k));
    }

}