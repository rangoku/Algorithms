package main;

public class Profiler {

    /**
     * @param task is a task to profile
     * @return task execution time in millis
     */
    public static long profile(Runnable task) {
        long start = System.currentTimeMillis();
        task.run();

        return System.currentTimeMillis() - start;
    }
}
