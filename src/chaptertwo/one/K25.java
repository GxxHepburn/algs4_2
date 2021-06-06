package chaptertwo.one;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author gxx
 * @create 2021-06-03 17:55
 */
public class K25 extends Example {

    public static void main(String[] args) {
        String alg1 = "K25";
        String alg2 = "Insertion";
        int N = 100000;
        int T = 1;
        double t_k25 = SortCompare.timeRandomInput(alg1, N ,T);
        double t_insertion = SortCompare.timeRandomInput(alg2, N, T);
        StdOut.printf("For %d random Doubles\n  %s is", N, alg1);
        StdOut.printf(" %.1f times faster than %s\n", t_insertion/t_k25, alg2);
    }

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            Comparable t = a[i];
            int j;
            for (j = i; j > 0 && t.compareTo(a[j-1]) < 0; j--) {
                a[j] = a[j-1];
            }
            a[j] = t;
        }
    }
}
