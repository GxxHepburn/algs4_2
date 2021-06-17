package chaptertwo.two;

import chaptertwo.one.Example;

import java.util.Arrays;

/**
 * @author gxx
 * @create 2021-06-17 11:10
 */
public class K11 {

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

    public static void sort(Comparable[] a) {
        Comparable[] b = Arrays.copyOf(a, a.length);
        sort(b, a ,0, a.length-1);
    }

    private static void sort(Comparable[] a, Comparable[] b, int lo, int hi) {

        if (hi <= lo + 15) {
            insertion(b, lo, hi);
            return;
        }
        int mid = lo + (hi - lo) / 2;

        sort(b, a, lo, mid);
        sort(b, a, mid + 1, hi);

        if (Example.less(a[mid+1], a[mid])) {
            merge(a, b, lo, mid, hi);
        }
    }

    public static void merge(Comparable[] a, Comparable[] b, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                b[k] = a[j++];
            } else if (j > hi) {
                b[k] = a[i++];
            } else if (Example.less(a[j], a[i])) {
                b[k] = a[j++];
            } else {
                b[k] = a[i++];
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
