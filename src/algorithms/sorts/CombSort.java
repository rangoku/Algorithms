package algorithms.sorts;

import org.jetbrains.annotations.NotNull;

public class CombSort {

    private static final double FACTOR = 1.24733095010;

    private static <E extends Comparable<? super E>>
    void combSort(E[] a) {

        double step = a.length - 1;

        while (step >= 1) {

            for (int i = 0; i + step < a.length; i++) {

                if (a[i].compareTo(a[(int)(i + step)]) > 0) {
                    E temp = a[i];
                    a[i] = a[(int)(i + step)];
                    a[(int)(i + step)] = temp;
                }
            }
            step /= FACTOR;
        }

        BubbleSort.sort(a);

    }

    public static <E extends Comparable<? super E>>
    void sort(@NotNull E[] a) {
        combSort(a);
    }


}
