package chaptertwo.one;

import edu.princeton.cs.algs4.StdOut;

/**
 * 实验发现，N=1000时，Insertion快于哨兵插入排序，0.9倍
 *  N=10000时，哨兵插入排序1.1倍速度快于Insertion
 * @author gxx
 * @create 2021-06-07 3:11
 */
public class K24 extends Example {

    public static void main(String[] args) {
        String alg1 = "K24";
        String alg2 = "Insertion";
        int N = 1000;
        int T = 1;
        double t_k24 = SortCompare.timeRandomInput(alg1, N, T);
        double t_insertion = SortCompare.timeRandomInput(alg2, N, T);
        StdOut.printf("For %d random Doubles\n  %s is", N, alg1);
        StdOut.printf(" %.1f times faster than %s\n", t_insertion/t_k24, alg2);
    }

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        Comparable min = a[0];
        int minIndex = 0;
        for (int i = 0; i < N; i++) {
            if (less(a[i], min)) {
                min = a[i];
                minIndex = i;
            }
        }
        exch(a, 0, minIndex);
        for (int i = 1; i < N; i++) {
            for (int j = i; less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
        }
    }
}
