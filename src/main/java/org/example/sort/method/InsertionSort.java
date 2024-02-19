package org.example.sort.method;

import org.example.sort.Sort;
import org.example.sort.SortPart;

public class InsertionSort extends Sort {


    protected InsertionSort(int[] arr, SortPart sortPart) {
        super(arr, sortPart);
    }

    @Override
    protected int[] sort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int current = arr[i];
            int j = i;

            while (j > 0 && arr[j - 1] > current) {
                swap(arr, j, j - 1);
                j--;
            }
        }

        return arr;
    }

}
