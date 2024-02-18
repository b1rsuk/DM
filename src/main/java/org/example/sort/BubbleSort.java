package org.example.sort;

public class BubbleSort extends Sort {


    public BubbleSort(int[] arr) {
        super(arr);
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
