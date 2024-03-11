package org.example.sort;

import java.util.Arrays;

public abstract class Sort {
    protected final int[] arr;
    protected final int[] partOfArr;

    protected Sort(int[] arr, SortPart sortPart, String sortName) {
        int[] copyArr = arr.clone();

        int from = sortPart.from;
        int to = sortPart.to;
        int[] partOfArr = Arrays.copyOfRange(copyArr, from, (to));

        int[] sortedPart = sort(partOfArr);

        for (int i = from, j = 0; i < to; i++, j++) {
            copyArr[i] = sortedPart[j];
        }

        this.partOfArr = partOfArr;
        this.arr = copyArr;
    }

    protected abstract int[] sort(int[] arr);

    protected void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int[] getArr() {
        return arr;
    }

    private int minItem() {
        return this.partOfArr[0];
    }

    private int maxItem() {
        return this.partOfArr[partOfArr.length - 1];
    }

    @Override
    public String toString() {
        return String.format("Arrays: %s. Sorted part: %s. Min: %s. Max: %s", Arrays.toString(this.arr), Arrays.toString(this.partOfArr), minItem(), maxItem());
    }

}
