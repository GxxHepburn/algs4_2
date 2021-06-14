package chaptertwo.two;

import chaptertwo.one.Example;
import edu.princeton.cs.algs4.StdOut;

public class K5 {

    private static Comparable[] aux;

    public static void main(String[] args) {
        /**
         *  N = 39
         *  自顶向下
         *      merge(a, 0, 0, 1)       2
         * merge(a, 0, 1, 2)       3
         * merge(a, 3, 3, 4)       2
         * merge(a, 0, 2, 4)       5
         * merge(a, 5, 5, 6)       2
         * merge(a, 5, 6, 7)       3
         * merge(a, 8, 8, 9)       2
         * merge(a, 5, 7, 9)       5
         * merge(a, 0, 4, 9)       10
         * merge(a, 10, 10, 11)       2
         * merge(a, 10, 11, 12)       3
         * merge(a, 13, 13, 14)       2
         * merge(a, 10, 12, 14)       5
         * merge(a, 15, 15, 16)       2
         * merge(a, 15, 16, 17)       3
         * merge(a, 18, 18, 19)       2
         * merge(a, 15, 17, 19)       5
         * merge(a, 10, 14, 19)       10
         * merge(a, 0, 9, 19)       20
         * merge(a, 20, 20, 21)       2
         * merge(a, 20, 21, 22)       3
         * merge(a, 23, 23, 24)       2
         * merge(a, 20, 22, 24)       5
         * merge(a, 25, 25, 26)       2
         * merge(a, 25, 26, 27)       3
         * merge(a, 28, 28, 29)       2
         * merge(a, 25, 27, 29)       5
         * merge(a, 20, 24, 29)       10
         * merge(a, 30, 30, 31)       2
         * merge(a, 30, 31, 32)       3
         * merge(a, 33, 33, 34)       2
         * merge(a, 30, 32, 34)       5
         * merge(a, 35, 35, 36)       2
         * merge(a, 37, 37, 38)       2
         * merge(a, 35, 36, 38)       4
         * merge(a, 30, 34, 38)       9
         * merge(a, 20, 29, 38)       19
         * merge(a, 0, 19, 38)       39
         *
         *  自底向上
         *      sz = 1
         *      merge(a, 0, 0, 1)       2
         *      merge(a, 2, 2, 3)       2
         *      merge(a, 4, 4, 5)       2
         *      merge(a, 6, 6, 7)       2
         *      merge(a, 8, 8, 9)       2
         *      merge(a, 10, 10, 11)    2
         *      merge(a, 12, 12, 13)    2
         *      merge(a, 14, 14, 15)    2
         *      merge(a, 16, 16, 17)    2
         *      merge(a, 18, 18, 19)    2
         *      merge(a, 20, 20, 21)    2
         *      merge(a, 22, 22, 23)    2
         *      merge(a, 24, 24, 25)    2
         *      merge(a, 26, 26, 27)    2
         *      merge(a, 28, 28, 29)    2
         *      merge(a, 30, 30, 31)    2
         *      merge(a, 32, 32, 33)    2
         *      merge(a, 34, 34, 35)    2
         *      merge(a, 36, 36, 37)    2
         *
         *      sz = 2
         *      merge(a, 0, 1, 3)       4
         *      merge(a, 4, 5, 7)       4
         *      merge(a, 8, 9, 11)      4
         *      merge(a, 12, 13, 15)    4
         *      merge(a, 16, 17, 19)    4
         *      merge(a, 20, 21, 23)    4
         *      merge(a, 24, 25, 27)    4
         *      merge(a, 28, 29, 31)    4
         *      merge(a, 32, 33, 35)    4
         *      merge(a, 36, 37, 38)    3
         *
         *      sz = 4
         *      merge(a, 0, 3, 7)       8
         *      merge(a, 8, 11, 15)     8
         *      merge(a, 16, 19, 23)    8
         *      merge(a, 24, 27, 31)    8
         *      merge(a, 32, 35, 38)    7
         *
         *      sz = 8
         *      merge(a, 0, 7, 15)      16
         *      merge(a, 16, 23, 31)    16
         *
         *      sz = 16
         *      merge(a, 15, 31)        32
         *      merge(a, 31, 38)        39
         */

        int N = 39;
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++) {
            a[i] = N-i;
        }
//        sortToBottom(a);
        sortToUp(a);
    }

    /**
     * 暑促每次自底向上的归并过程
     */
    public static void sortToUp(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz) {
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
                StdOut.println("merge(a, " + lo + ", " + (lo + sz - 1) + ", " + (Math.min(lo + sz + sz - 1, N - 1)) + ")       " + (Math.min(lo + sz + sz - 1, N - 1) - lo + 1));
            }
        }
    }

    /**
     * 输出每次自顶向下的归并过程
     *
     */
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

    public static void sortToBottom(Comparable[] a) {
        aux = new Comparable[a.length];
        sortToBottom(a ,0, a.length-1);
    }

    private static void sortToBottom(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sortToBottom(a, lo, mid);
        sortToBottom(a, mid + 1, hi);
        merge(a, lo, mid, hi);
        StdOut.println("merge(a, " + lo + ", " + mid + ", " + hi + ")       " + (hi - lo + 1));
    }
}
