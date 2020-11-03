package main;

import algorithms.sorts.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Integer[] a1 = {12,3,4,100,5,6,5,4,3,3,4,4,5,5,6,7,7,78,7,6,5,3,23,2,3,23,13324,42,1,3,42,2,36,27,81};
        Integer[] a2 = {12,3,4,100,5,6,5,4,3,3,4,4,5,5,6,7,7,78,7,6,5,3,23,2,3,23,13324,42,1,3,42,2,36,27,81};


        System.out.println("Original array:");
        System.out.println(Arrays.toString(a1));

        System.out.println("Selection sort : " +
                Profiler.profile(() -> SelectionSort.sort(a1))
                + "ms");

        System.out.println("Heap sort : " +
                Profiler.profile(() -> HeapSort.sort(a2))
                + "ms");


        System.out.println("a1: " + Arrays.toString(a1));
        System.out.println("a2: " + Arrays.toString(a2));
    }
}
