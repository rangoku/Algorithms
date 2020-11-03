package algorithms.sorts;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

public class QuickSort {

    private static <E extends Comparable<? super E>>
    void qsort(E[] a, int low, int high) {

        int mid = low + (high - low) / 2;
        E pivot = a[mid];

        int i = low, j = high;
        while (i <= j) {

            while(a[i].compareTo(pivot) < 0)
                ++i;

            while (a[j].compareTo(pivot) > 0)
                --j;

            if (i <= j) {
                E temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                ++i;
                --j;
            }
        }

        if (low < j)
            qsort(a, low, j);
        if (high > i)
            qsort(a, i, high);
    }

    private static <E extends Comparable<? super E>>
    void qsort(E[] a, int low, int high, Comparator<E> comparator) {

        int mid = low + (high - low) / 2;
        E pivot = a[mid];

        int i = low, j = high;
        while (i <= j) {

            while(comparator.compare(a[i], pivot) < 0)
                ++i;

            while (comparator.compare(a[j], pivot) > 0)
                --j;

            if (i <= j) {
                E temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                ++i;
                --j;
            }
        }

        if (low < j)
            qsort(a, low, j);
        if (high > i)
            qsort(a, i, high);
    }

    public static <E extends Comparable<? super E>>
    void sort(@NotNull E[] a) {
        qsort(a, 0, a.length - 1);
    }

    public static <E extends Comparable<? super E>>
    void sort(@NotNull E[] a, Comparator<E> comparator) {
        qsort(a, 0, a.length - 1, comparator);
    }


}

