package algorithms.sorts;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class PigeonholeSort {

    public static void sort(@NotNull int[] a) {
        psort(a);
    }

    private static void psort(int[] a) {

        @SuppressWarnings("OptionalGetWithoutIsPresent")
        int max = Arrays.stream(a).max().getAsInt();
        int min = Arrays.stream(a).min().getAsInt();
        int range = max - min + 1;
        int[] pHoles = new int[range];

        for (int value : a)
            ++pHoles[value - min];

        int index = 0;

        for (int i = 0; i < range; ++i)
            while (pHoles[i]-- > 0)
                a[index++] = i + min;
    }
}
