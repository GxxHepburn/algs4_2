package chaptertwo.one;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

/**
 * @author gxx
 * @create 2021-06-07 16:55
 */
public class K28 {

    public static void main(String[] args) {
        int N = 10000;
        int T = 1;
        Integer[] a = new Integer[N];
        RandomBag<Integer> randomBag = new RandomBag<>();
        for (int i = 0; i < N / 2; i++) {
            randomBag.add(1);
            randomBag.add(2);
        }
        int index = 0;
        for (Integer integer : randomBag) {
            a[index++] = integer;
        }
        Integer[] temp = Arrays.copyOf(a, a.length);
        double time_insertion = time("Insertion", temp);
        temp = Arrays.copyOf(a, a.length);
        double time_selection = time("Selection", temp);

        StdOut.printf("For %d random Integer\n  %s is", N, "Insertion");
        StdOut.printf(" %.1f times faster than %s\n", time_selection/time_insertion, "Selection");
    }

    public static double time(String alg, Integer[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion")) {
            new Insertion().sort(a);
        }
        if (alg.equals("Selection")) {
            new Selection().sort(a);
        }
        if (alg.equals("Shell")) {
            new Shell().sort(a);
        }
        if (alg.equals("K24")) {
            new K24().sort(a);
        }
        if (alg.equals("K25")) {
            new K25().sort(a);
        }
        return  timer.elapsedTime();
    }
}
