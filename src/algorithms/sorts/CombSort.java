package algorithms.sorts;

import org.jetbrains.annotations.NotNull;

public class CombSort {

    private static final double FACTOR = 1.247330;

    private static <E extends Comparable<? super E>>
    void combSort(E[] a) {

        int step = a.length;
        boolean swapped = true;

        while (step > 1 || swapped) {

            if (step > 1)
                step = (int)(step / FACTOR);

            swapped = false;
            int i = 0;
            while (i + step < a.length) {

                if (a[i].compareTo(a[i + step]) > 0) {
                    E temp = a[i];
                    a[i] = a[i + step];
                    a[i + step] = temp;
                    swapped = true;
                }
                ++i;
            }
        }
    }

    public static <E extends Comparable<? super E>>
    void sort(@NotNull E[] a) {
        combSort(a);
    }


}
