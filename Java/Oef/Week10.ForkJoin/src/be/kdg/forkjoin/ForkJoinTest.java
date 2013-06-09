package be.kdg.forkjoin;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinTest {
    public static void main(String[] args) {
        int cores = 4;
        int size = 1000;
        long start;
        long end;

        ForkJoinPool pool = new ForkJoinPool(cores);

        double[] numbers = new double[1_000_000];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (double) i;
        }
        Transform task = new Transform(numbers, 0, numbers.length, size);

        start = System.nanoTime();
        pool.invoke(task);
        end = System.nanoTime();

        System.out.println("Level of parallelism: " + cores);
        System.out.println("Sequential threshold: " + size);
        System.out.println("Elapsed time: " + (end - start) + " ns");
        System.out.println();
    }
}



/*
Level of parallelism: 1
Sequential threshold: 1000
Elapsed time: 68966072 ns

Level of parallelism: 2
Sequential threshold: 1000
Elapsed time: 40618122 ns

Level of parallelism: 4
Sequential threshold: 1000
Elapsed time: 27427841 ns

Level of parallelism: 8
Sequential threshold: 1000
Elapsed time: 27920470 ns
*/

/*
Quad core!

Level of parallelism: 1
Sequential threshold: 1000
Elapsed time: 66039672 ns

Level of parallelism: 2
Sequential threshold: 1000
Elapsed time: 34843701 ns

Level of parallelism: 4
Sequential threshold: 1000
Elapsed time: 19279443 ns

Level of parallelism: 8
Sequential threshold: 1000
Elapsed time: 21301642 ns
*/