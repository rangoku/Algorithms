package algorithms.sorts;

import org.jetbrains.annotations.NotNull;

public class HeapSort {

    public static <E extends Comparable<? super E>>
    void sort(@NotNull E[] a) {
        hsort(a);
    }

    private static <E extends Comparable<? super E>>
    void hsort(E[] a) {

        int n = a.length;

        for (int i = n / 2 - 1; i >= 0 ; --i)
            heapify(a, n, i);

        for (int i = n - 1; i >= 0 ; --i) {
            E temp = a[0];
            a[0] = a[i];
            a[i] = temp;

            heapify(a, i, 0);
        }

    }

    private static <E extends Comparable<? super E>>
    void heapify(E[] a, int n, int i) {

        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && a[l].compareTo(a[largest]) > 0)
            largest = l;

        if (r < n && a[r].compareTo(a[largest]) > 0)
            largest = r;

        if (largest != i) {
            E temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;

            heapify(a, n, largest);
        }
    }
}
