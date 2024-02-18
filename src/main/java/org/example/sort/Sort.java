package org.example.sort;

import java.util.Arrays;

public abstract class Sort {
    protected int[] arr;

    public Sort(int[] arr) {
        this.arr = sort(arr.clone());
    }

    protected abstract int[] sort(int[] arr);

    protected void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}
