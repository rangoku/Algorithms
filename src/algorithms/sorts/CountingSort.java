package algorithms.sorts;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class CountingSort {

    public static void sort(@NotNull int[] a) {
        countingSort(a);
    }

    private static void countingSort(int[] a) {

        @SuppressWarnings("OptionalGetWithoutIsPresent")
        int max = Arrays.stream(a).max().getAsInt();
        int min = Arrays.stream(a).min().getAsInt();
        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[a.length];

        for (int value : a)
            ++count[value - min];

        for (int i = 1; i < count.length; ++i)
            count[i] += count[i-1];


        for (int i = a.length-1; i >= 0; --i) {
            output[count[ a[i] - min ] - 1] = a[i];
            --count[ a[i] - min ];
        }

        System.arraycopy(output, 0, a, 0, a.length);

    }

}
