package org.example;

import java.util.Arrays;
import java.util.Scanner;

import static org.example.Comb.A;
import static org.example.Comb.C;
import static org.example.Comb._A;
import static org.example.Comb._C;
import static org.example.Comb.factorial;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();

        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();

        scanner.close();
        calculate(n, k);

        int[] a = generateArray(n);
        System.out.println("\n");
        printAllPermutations(a, n);
        System.out.println("\n");
        printNextPermutations(a, n);
    }

    private static void calculate(int n, int k) {
        System.out.println("Permutations: " + Comb.factorial(n));
        System.out.println("Arrangements without repetition: " + Comb.A(n, k));
        System.out.println("Arrangements with repetition: " + Comb._A(n, k));
        System.out.println("Combinations without repetition: " + Comb.C(n, k));
        System.out.println("Combinations with repetition: " + Comb._C(n, k));
    }

    private static int[] generateArray(int n) {
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = i + 1;
        }
        return A;
    }

    private static void printAllPermutations(int[] a, int n) {
        for (int i = 1; i <= factorial(n); i++) {
            System.out.println("Permutation " + i + ": " + Arrays.toString(a));
            Comb.genPerm(a, n);
        }
    }

    private static void printNextPermutations(int[] a, int n) {
        // Виведення початкової перестановки
        System.out.println("Permutation 1: " + Arrays.toString(a));

        // Генерування та виведення наступних перестановок
        for (int i = 2; i <= factorial(n); i++) {
            Comb.genPerm(a, n);
            System.out.println("Permutation " + i + ": " + Arrays.toString(a));
        }
    }
}