package org.example.sort;

public class InsertionSort extends Sort {

    public InsertionSort(int[] arr) {
        super(arr);
    }

    @Override
    protected int[] sort(int[] arr) {
        int size = arr.length;

        for (int step = 1; step < size; step++) {
            int key = arr[step];
            int j = step - 1;

            while (j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j];
                --j;
            }

            arr[j + 1] = key;
        }

        return arr;
    }

}
