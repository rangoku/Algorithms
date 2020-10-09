package main;

import algorithms.graphs.*;
import algorithms.sorts.BubbleSort;
import algorithms.sorts.CombSort;
import algorithms.sorts.QuickSort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Integer[] a1 = {12,3,4,100,5,6,5,4,3,3,4,4,5,5,6,7,7,78,7,6,5,3,23,2,3};
        Integer[] a2 = {12,3,4,100,5,6,5,4,3,3,4,4,5,5,6,7,7,78,7,6,5,3,23,2,3};

        System.out.println("Original array:");
        System.out.println(Arrays.toString(a1));

        long durationOfCombSort = Profiler.profile(() -> CombSort.sort(a1));
        long durationOfQSort = Profiler.profile(() -> QuickSort.sort(a2));

        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));

        System.out.println("CombSort: " + durationOfCombSort + "ms");
        System.out.println("QSort: " + durationOfQSort + "ms");

    }
}
