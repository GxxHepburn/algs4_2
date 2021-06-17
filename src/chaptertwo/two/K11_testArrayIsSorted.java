package chaptertwo.two;

import chaptertwo.one.Example;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author gxx
 * @create 2021-06-17 11:30
 */
public class K11_testArrayIsSorted {

    public static void main(String[] args) {
        int N = 100;
        Integer[] a = new Integer[N];
        for (int i = 0; i < 50; i++) {
            a[i] = 50 - i;
        }
        for (int i = 50; i < N; i++) {
            a[i] = i;
        }
        sort(a);
        for (Integer integer : a) {
            System.out.println("integer = " + integer);
        }
    }

    private static Comparable[] aux;
    private static int compareCnt;
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
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        StdOut.println("比较是否有序: " + ++compareCnt + " , lo: " + lo + " , mid: " +mid +  ", hi: " + hi);
        if (Example.less(a[mid+1], a[mid])) {
            StdOut.println("归并: " + ++mergeCnt + " , lo: " + lo + " , mid: " +mid + ", hi: " + hi);
            merge(a, lo, mid, hi);
        }
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
}
