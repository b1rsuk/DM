package org.example;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class Narayana {
    public static int findRightMaxIndex(List<Integer> permutation) {
        for (int i = permutation.size() - 2; i >= 0; i--) {
            if (permutation.get(i) < permutation.get(i + 1)) {
                return i;
            }
        }
        return -1;
    }

    public static int findIndexBiggerElement(List<Integer> permutation, int element) {
        for (int i = permutation.size() - 1; i >= 0; i--) {
            if (permutation.get(i) > element) {
                return i;
            }
        }

        return -1;
    }

    public static void reverse(List<Integer> permutation, int from) {
        List<Integer> partOfPermutation = permutation.subList(from, permutation.size());
        Collections.reverse(partOfPermutation);
        List<Integer> copyOfOriginal = permutation.subList(0, from);

        permutation.clear();
        permutation.addAll(copyOfOriginal);
        permutation.addAll(partOfPermutation);
    }
}
