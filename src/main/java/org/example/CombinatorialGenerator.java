package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public final class CombinatorialGenerator {

    public static void genPerm(List<Integer> permutation) {
        System.out.println(permutation);
        for (int i = 1; i < Comb.factorial(permutation.size()); i++) {
            int maxIndex = findMaxIndex(permutation);
            int maxElem = permutation.get(maxIndex);
            int swapIndex = findIndexBiggerElement(permutation, maxElem);
            Collections.swap(permutation, maxIndex, swapIndex);
            reverse(permutation, ++maxIndex);
            System.out.println(permutation);
        }
    }

    public static void genComb(List<Integer> list, int k, int n) {
        List<Integer> comb = new ArrayList<>(list.subList(0, k));
        while (true) {
            System.out.println(comb);
            int m = -1;
            for (int i = k - 1; i >= 0; i--) {
                if (comb.get(i) <= n - k + i) {
                    comb.set(i, comb.get(i) + 1);
                    m = i;
                    break;
                }
            }
            if (m == -1) {
                break;
            }
            for (int i = m + 1; i < k; i++) {
                comb.set(i, comb.get(i - 1) + 1);
            }
        }
    }

    private static int findMaxIndex(List<Integer> permutation) {
        for (int i = permutation.size() - 2; i >= 0; i--) {
            if (permutation.get(i) < permutation.get(i + 1)) {
                return i;
            }
        }

        return -1;
    }

    private static int findIndexBiggerElement(List<Integer> permutation, int element) {
        for (int i = permutation.size() - 1; i >= 0; i--) {
            if (permutation.get(i) > element) {
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
}
