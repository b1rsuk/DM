package org.example.sort.method;

import org.example.sort.Sort;
import org.example.sort.SortPart;

public class SortMethod {
    private final int[] arr;
    private final SortPart sortPart;

    public SortMethod(int[] arr, SortPart sortPart) {
        this.arr = arr;
        this.sortPart = sortPart;
    }


    public Sort bubbleSort() {
        return new BubbleSort(arr, sortPart);
    }

    public Sort insertionSort() {
        return new InsertionSort(arr, sortPart);
    }

    public Sort selectionSort() {
        return new SelectionSort(arr, sortPart);
    }
}
