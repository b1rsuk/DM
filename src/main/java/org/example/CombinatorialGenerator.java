package org.example;

import org.example.sort.SortPart;
import org.example.sort.method.SortMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public final class CombinatorialGenerator {

    public static void genPerm(int[] permutation) {
        System.out.println(Arrays.toString(permutation));
        for (int i = 1; i < Comb.factorial(permutation.length); i++) {
            int maxIndex = findMaxIndex(permutation);
            int maxElem = permutation[maxIndex];
            int swapIndex = findIndexBiggerElement(permutation, maxElem);
            swap(permutation, maxIndex, swapIndex);

            SortPart sortPart = new SortPart(maxIndex + 1, permutation.length);
            SortMethod sortMethod = new SortMethod(permutation, sortPart);
            permutation = sortMethod.bubbleSort().getArr();

            System.out.println(Arrays.toString(permutation));
        }
    }

    public static void genComb(int k, int n) {
        int[] comb = new int[k];
        for (int i = 0; i < comb.length; i++) {
            comb[i] = i + 1;
        }

        while (true) {
            System.out.println(Arrays.toString(comb));
            int m = -1;
            for (int i = k - 1; i >= 0; i--) {
                if (comb[i] <= n - k + i) {
                    comb[i] += 1;
                    m = i;
                    break;
                }
            }
            if (m == -1) {
                break;
            }
            for (int i = m + 1; i < k; i++) {
                comb[i] = comb[i - 1] + 1;
            }
        }
    }

    private static int findMaxIndex(int[] permutation) {
        for (int i = permutation.length - 2; i >= 0; i--) {
            if (permutation[i] < permutation[i + 1]) {
                return i;
            }
        }

        return -1;
    }

    private static int findIndexBiggerElement(int[] permutation, int element) {
        for (int i = permutation.length - 1; i >= 0; i--) {
            if (permutation[i] > element) {
                return i;
            }
        }

        return -1;
    }

    private static void reverse(List<Integer> list, int fromIndex) {
        List<Integer> tail = new ArrayList<>(list.subList(fromIndex, list.size()));
        Collections.reverse(tail);
        List<Integer> head = new ArrayList<>(list.subList(0, fromIndex));

        list.clear();

        List<Integer> reversedList = Stream.concat(head.stream(), tail.stream())
                .toList();

        list.addAll(reversedList);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
