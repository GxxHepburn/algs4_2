package chaptertwo.two;

import chaptertwo.one.Example;

import java.util.Arrays;

/**
 * @author gxx
 * @create 2021-06-17 11:38
 */
public class K11_exchArraysBetweenMerge {

    public static void main(String[] args) {

        int N = 10;
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
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(b, a, lo, mid);
        sort(b, a, mid + 1, hi);

        merge(a, b, lo, mid, hi);
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
}
