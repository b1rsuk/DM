package org.example;

import org.example.sort.BubbleSort;
import org.example.sort.Sort;
import org.example.sort.SortMethod;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = {4, 23, 4, -1, 0, 7, 3, 1, 4, 9};
        System.out.println(Arrays.toString(Arrays.stream(arr).sorted().toArray()));

        SortMethod sortMethod = new SortMethod();

        Sort bubbleSort = sortMethod.bubbleSort(arr);
        System.out.println(bubbleSort);

        Sort InsertionSort = sortMethod.InsertionSort(arr);
        System.out.println(InsertionSort);

    }

}