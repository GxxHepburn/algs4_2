package chaptertwo.one;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * shell排序的倍率是2.5，选择和插入都是在4.
 * @author gxx
 * @create 2021-06-07 16:32
 */
public class K27 {

    public static void main(String[] args) {
        int N = 128;
        int T = 1;
        while (true) {
            double[] rst = timeRandomInput(N, T);
            double time_Shell = rst[0];
            double time_insertion = rst[1];
            double time_selection = rst[2];
            StdOut.printf("For %d random Doubles\n  %s is", N, "Shell");
            StdOut.printf(" %.1f times faster than %s\n", time_insertion/time_Shell, "Insertion");
            System.out.println();
            StdOut.printf("For %d random Doubles\n  %s is", N, "Shell");
            StdOut.printf(" %.1f times faster than %s\n", time_selection/time_Shell, "Selection");
            N += N;
        }
    }

    public static double[] timeRandomInput(int N, int T) {
        double total_shell = 0.0d;
        double total_selection = 0.0d;
        double total_insertion = 0.0d;
        Double[] a = new Double[N];
        Double[] temp;
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < N; j++) {
                a[j] = StdRandom.uniform();
            }
            temp = Arrays.copyOf(a, a.length);
            total_shell += SortCompare.time("Shell", temp);
            temp = Arrays.copyOf(a, a.length);
            total_insertion += SortCompare.time("Insertion", temp);
            temp = Arrays.copyOf(a, a.length);
            total_selection += SortCompare.time("Selection", temp);
        }
        double[] rst = new double[3];
        rst[0] = total_shell;
        rst[1] = total_insertion;
        rst[2] = total_selection;
        return rst;
    }
}
