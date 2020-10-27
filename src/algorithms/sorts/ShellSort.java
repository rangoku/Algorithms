package algorithms.sorts;

import org.jetbrains.annotations.NotNull;

public class ShellSort {

    public static <E extends Comparable<? super E>>
    void sort(@NotNull E[] a) {
        shellSort(a);
    }

    private static <E extends Comparable<? super E>>
    void shellSort(E[] a) {

        for (int step = a.length / 2; step > 0; step /= 2) {

            for (int i = step; i < a.length; ++i) {

                for (int j = i - step; j >= 0 && a[j].compareTo(a[j + step]) > 0; j -= step) {
                    E temp = a[j];
                    a[j] = a[j + step];
                    a[j + step] = temp;
                }
            }
        }
     }
}
