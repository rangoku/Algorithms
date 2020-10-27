package algorithms.sorts;

import org.jetbrains.annotations.NotNull;

public class SelectionSort {

    public static <E extends Comparable<? super E>>
    void sort(@NotNull E[] a) {
        selectionSort(a);
    }

    private static <E extends Comparable<? super E>>
    void selectionSort(E[] a) {

        for (int i = 0; i < a.length - 1; ++i) {

            int min_index = getMinElementIndex(a, i, a.length);

            E temp = a[min_index];
            a[min_index] = a[i];
            a[i] = temp;
        }
    }

    private static <E extends Comparable<? super E>>
    int getMinElementIndex(E[] a, int begin, int end) {

        int min_index = begin;

        for (int i = begin; i < end; ++i)
            if (a[i].compareTo(a[min_index]) < 0)
                min_index = i;

        return min_index;
    }
}
