package chaptertwo.two;

import chaptertwo.one.Example;

/**
 * @author gxx
 * @create 2021-06-17 10:16
 */
public class K9 {

    public static void main(String[] args) {

        int N = 10;
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++) {
            a[i] = N-i;
        }
        for (Integer integer : a) {
            System.out.println("integer = " + integer);
        }
        sort(a);
        for (Integer integer : a) {
            System.out.println("integer = " + integer);
        }
    }

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a ,0, a.length-1, aux);
    }

    private static void sort(Comparable[] a, int lo, int hi, Comparable[] aux) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid, aux);
        sort(a, mid + 1, hi, aux);
        merge(a, lo, mid, hi, aux);
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi, Comparable[] aux) {
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
