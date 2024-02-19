package org.example;

import org.example.sort.Sort;
import org.example.sort.SortPart;
import org.example.sort.method.SortMethod;

import java.util.Arrays;

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

}