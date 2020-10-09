package algorithms.greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class KnapsackProblem {

    private static int N = 3;  // number of elements
    private static double bag_capacity = 50;
    private static double[] w; // weights
    private static double[] v; // values

    // will store count of each element by index
    private static double[] counts = new double[N];

    public KnapsackProblem(int numberOfElement, double bag_capacity, double[] weights, double[] values) {
        N = numberOfElement;
        KnapsackProblem.bag_capacity = bag_capacity;
        w  = weights;
        v = values;
    }

    /**
     * @return a values of every single element
     */
    private static ArrayList<Double> getUnitV () {
        ArrayList<Double> unitV = new ArrayList<>();

        for (int i = 0; i < N; i++) {

            unitV.add(i, (v[i] / w[i]));
        }

        return unitV;
    }

    /**
     * @return the biggest element in a
     */
    private static double getMax (ArrayList<Double> a) {
        double max = 0;

        for (double i : a) {
            if (i > max) max = i;
        }
        return max;
    }

    /**
     *
     * @param element - element to put in bag
     * @param index - index of element (for counts)
     * @return true if bag !full
     */
    private static boolean fill_bag (double element, int index) {

        if (bag_capacity - element <= 0) {
            counts[index] = bag_capacity;
            bag_capacity = 0;
            return false;
        }
        else {
            counts[index] = element;
            bag_capacity -= element;
            return true;
        }

    }

    /**
     * @return the biggest possible sum of elements' values to store
     */
    private static double sum () {
        double sum = 0;

        for (int i = 0; i < N; i++) {
            sum += counts[i] * (v[i] / w[i]);
        }
        return sum;
    }

    /**
     * Try to fill the bag with most valuable elements
     */
    public static void solve() {

        ArrayList<Double> unitV = getUnitV();

        for (int i = 0; i < N; i++) {

            double max = getMax(unitV);
            int index = unitV.indexOf(max);

            unitV.set(index, -1.0);

            if (!fill_bag(w[index], index)) // => bag is full
                break;

        }
        //result
        System.out.println("Set: " + Arrays.toString(counts));
        System.out.println("Capacity left: " + bag_capacity);
        System.out.println("Sum: " + sum());
    }

}

