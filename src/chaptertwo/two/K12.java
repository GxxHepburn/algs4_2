package chaptertwo.two;

import chaptertwo.one.Example;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * 题目中的max(M, N/M)
 *       如果一味的追球最少的额外空间，就会导致时间效率非常低，
 *       为了中和额外空间和时间效率，选择一个适合的M是必要的。
 *       max(M, N/M)就指出了这一点。
 * @author gxx
 * @create 2021-06-17 11:30
 */
public class K12 {

    public static void main(String[] args) {
        int N = 10000;
        int M = 250;
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform();
        }
        Stopwatch timer = new Stopwatch();
        sort(a, M);
        StdOut.println("time: " + timer.elapsedTime());
    }

    public static void sort(Comparable[] a, int M) {
        int N = a.length;
        Comparable[] aux = new Comparable[M];
        for (int lo = 0; lo < N; lo += M) {
            sort(a, aux, lo, lo + M - 1);
        }
        selectionSortBlock(a, M);
        for (int i = 1; i < N/M; i++) {
            if (Example.less(a[i*M], a[i*M-1])) {
                merge(a, aux, 0, i*M-1, (i+1)*M-1);
            }
        }
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        if (Example.less(a[mid + 1], a[mid])) {
            merge(a, aux, lo, mid, hi);
        }
    }

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        int m = hi - mid;
        for (int i = 0; i < m; i++) {
            aux[i] = a[mid+1+i];
        }
        int auxTop = m - 1;
        int aTop = mid;
        for (int k = hi; k >= lo; k--) {
            if (auxTop < 0) {
                a[k] = a[aTop--];
            } else if (aTop < lo) {
                a[k] = aux[auxTop--];
            } else if (Example.less(aux[auxTop], a[aTop])) {
                a[k] = a[aTop--];
            } else {
                a[k] = aux[auxTop--];
            }
        }
    }

    private static void selectionSortBlock(Comparable[] a, int M) {
        int length = a.length;
        int minIndex;
        for (int i = 0; i < length; i += M) {
            minIndex = i;
            for (int j = i + M; j < length; j += M) {
                if (Example.less(a[j], a[minIndex])) {
                    minIndex = j;
                }
            }
            exch(a, i, minIndex, M);
        }
    }

    private static void exch(Comparable[] a, int i, int j, int length) {
        Comparable t;
        for (int index = 0; index < length; index++) {
            t = a[i+index];
            a[i+index] = a[j+index];
            a[j+index] = t;
        }
    }
}
