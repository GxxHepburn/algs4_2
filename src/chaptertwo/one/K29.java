package chaptertwo.one;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

/**
 * 复杂序列效率显著高于原序列
 * @author gxx
 * @create 2021-06-07 17:35
 */
public class K29 {

    public static void main(String[] args) {
        int N = 400000;
        Double[] a = new Double[N];
        int[] seq = {1, 5, 19, 41, 109, 209, 505, 929, 2161, 3905, 8929, 16001, 36289, 64769, 14305, 260609};
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform();
        }
        Double[] temp = Arrays.copyOf(a, a.length);
        double t_shell = SortCompare.time("Shell", temp);

        Stopwatch timer = new Stopwatch();
        int index = seq.length-1;
        while (index >= 0) {
            int h = seq[index--];
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && Example.less(a[j], a[j-h]); j-=h) {
                    Example.exch(a, j, j-h);
                }
            }
        }
        double t_shell_2 = timer.elapsedTime();
        StdOut.printf("For %d random Doubles\n  %s is", N, "Shell");
        StdOut.printf(" %.1f times faster than %s\n", t_shell_2/t_shell, "Shell_2");
    }
}
