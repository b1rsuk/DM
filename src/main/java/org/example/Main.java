package org.example;

import org.example.sort.Sort;
import org.example.sort.SortPart;
import org.example.sort.method.SortMethod;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        SortPart sortPart = new SortPart(0, arr.length);

        System.out.println("Original arrays " + Arrays.toString(arr));
        SortMethod sortMethod = new SortMethod(arr, sortPart);

        Sort bubbleSort = sortMethod.bubbleSort();
        System.out.println(bubbleSort);

        Sort InsertionSort = sortMethod.insertionSort();
        System.out.println(InsertionSort);

        Sort selectionSort = sortMethod.selectionSort();
        System.out.println(selectionSort);

    }

    private static int[] readArrayFromConsole() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter numbers for the array (separate them by space)");
        String input = scanner.nextLine();
        String[] numbers = input.split(" ");
        int[] arr = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            arr[i] = Integer.parseInt(numbers[i]);
        }

        return arr;
    }

    public static SortPart readSortPartFromConsole() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the start index of the sorting range:");
        int from = scanner.nextInt();

        System.out.println("Enter the end index of the sorting range:");
        int to = scanner.nextInt();

        return new SortPart(from, to);
    }

}