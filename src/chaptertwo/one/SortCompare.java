package chaptertwo.one;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * @author gxx
 * @create 2021-06-03 20:28
 */
public class SortCompare {

    public static double time(String alg, Double[] a) {
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
        return  timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0d;
        Double[] a = new Double[N];
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < N; j++) {
                a[j] = StdRandom.uniform();
            }
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args) {
        String alg1 = "Insertion";
        String alg2 = "Selection";
        String alg3 = "Shell";
        int N = 100000;
        int T = 1;

//        double t1 = timeRandomInput(alg1, N, T);
//        System.out.println("Insertion = " + t1);
//        double t2 = timeRandomInput(alg2, N, T);
//        System.out.println("Selection = " + t2);
//        StdOut.printf("For %d random Doubles\n  %s is", N, alg1);
//        StdOut.printf(" %.1f times faster than %s\n", t2/t1, alg2);

//        double t3 = timeRandomInput(alg3, N, T);
//        System.out.println("Shell = " + t3);
//        double t4 = timeRandomInput(alg1, N, T);
//        System.out.println("Insertion = " + t4);
//        StdOut.printf("For %d random Doubles\n  %s is", N, alg1);
//        StdOut.printf(" %.1f times faster than %s\n", t4/t3, alg2);

        double t5 = timeRandomInput(alg3, N, T);
        System.out.println("Shell = " + t5);
        double t6 = timeRandomInput(alg2, N, T);
        System.out.println("Selection = " + t6);
        StdOut.printf("For %d random Doubles\n  %s is", N, alg3);
        StdOut.printf(" %.1f times faster than %s\n", t6/t5, alg2);
    }
}
