package chaptertwo.one;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * @author gxx
 * @create 2021-06-07 5:00
 */
public class K26 {

    public static void main(String[] args) {
        String alg1 = "K26";
        String alg2 = "Insertion";
        int N = 10000;
        int T = 5;
        double t_k26 = timeRandomInput(alg1, N ,T);
        double t_insertion = SortCompare.timeRandomInput(alg2, N, T);
        StdOut.printf("For %d random Doubles\n  %s is", N, alg1);
        StdOut.printf(" %.1f times faster than %s\n", t_insertion/t_k26, alg2);
    }

    public void sort(double[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0 && Example.less(a[j], a[j-1]); j--) {
                double temp = a[j];
                a[j] = a[j-1];
                a[j-1] = temp;
            }
        }
    }

    public static double time(String alg, double[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("K26")) {
            new K26().sort(a);
        }
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0d;
        double[] a = new double[N];
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < N; j++) {
                a[j] = StdRandom.uniform();
            }
            total += time(alg, a);
        }
        return total;
    }
}
