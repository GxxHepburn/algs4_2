package chaptertwo.two;

import chaptertwo.one.Example;

/**
 * @author gxx
 * @create 2021-06-17 10:31
 */
public class K10 {

    public static void main(String[] args) {

        int N = 11;
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
        merge(a, lo, mid, hi);
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {

        int i = lo;
        int j = hi;
        for (int k = lo; k <= mid; k++) {
            aux[k] = a[k];
        }

        for (int k = mid + 1; k <= hi; k++) {
            aux[k] = a[hi-k+mid+1];
        }

        for (int k = lo; k <= hi; k++) {
            if (Example.less(aux[j], aux[i])) {
                a[k] = aux[j--];
            } else {
                a[k] = aux[i++];
            }
        }
    }
}
