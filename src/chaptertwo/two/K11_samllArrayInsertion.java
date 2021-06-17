package chaptertwo.two;

import chaptertwo.one.Example;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author gxx
 * @create 2021-06-17 11:13
 */
public class K11_samllArrayInsertion {

    public static void main(String[] args) {

        int N = 100;
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++) {
            a[i] = N - i;
        }
        sort(a);
        for (Integer integer : a) {
            System.out.println("integer = " + integer);
        }
    }

    private static Comparable[] aux;
    private static int insertionCnt;
    private static int mergeCnt;

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a ,0, a.length-1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        if (mid - lo + 1 < 15) {
            StdOut.println("insert: " + ++insertionCnt + " , lo: " + lo + " , mid: " + mid);
            insertion(a, lo, mid);
        } else {
            StdOut.println("merge: " + ++mergeCnt + " , lo: " + lo + " , mid: " + mid);
            sort(a, lo, mid);
        }
        if (hi - mid < 15) {
            StdOut.println("insert: " + ++insertionCnt + " , mid+1: " + (mid+1) + " , hi: " + hi);
            insertion(a, mid + 1, hi);
        } else {
            StdOut.println("merge: " + ++mergeCnt + " , mid+1: " + (mid+1) + " , hi: " + hi);
            sort(a, mid + 1, hi);
        }
        merge(a, lo, mid, hi);
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (Example.less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    public static void insertion(Comparable[] a, int lo, int hi) {
        int N = hi - lo + 1;
        for (int i = lo+1; i <= hi; i++) {
            for (int j = i; j > lo && Example.less(a[j], a[j-1]); j--) {
                Example.exch(a, j, j-1);
            }
        }
    }
}
