package algorithms.sorts;

import org.jetbrains.annotations.NotNull;

public class BubbleSort {

    public static <E extends Comparable<? super E>>
    void sort(@NotNull E[] a) {

        for (int i = 0; i < a.length; ++i) {

            for (int j = 0; j < a.length - 1; ++j) {

                if (a[j].compareTo(a[j+1]) > 0) {
                    E temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }
}
