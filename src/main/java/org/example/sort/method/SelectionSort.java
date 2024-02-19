package org.example.sort.method;

import org.example.sort.Sort;
import org.example.sort.SortPart;

public class SelectionSort extends Sort {


    protected SelectionSort(int[] arr, SortPart sortPart) {
        super(arr, sortPart);
    }

    @Override
    protected int[] sort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < (n - 1); i++) {
            int min = i;

            for (int j = (i + 1); j < n; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }

            swap(arr, i, min);
        }

        return arr;
    }

}
