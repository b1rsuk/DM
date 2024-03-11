package org.example.sort.method;

import org.example.sort.Sort;
import org.example.sort.SortPart;

public class BubbleSort extends Sort {

    protected BubbleSort(int[] arr, SortPart sortPart) {
        super(arr, sortPart, "BubbleSort");
    }

    @Override
    protected int[] sort(int[] arr) {
        int size = arr.length;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < (size - 1); j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }

        return arr;
    }

}
