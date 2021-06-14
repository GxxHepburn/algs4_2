package chaptertwo.two;

import chaptertwo.one.Example;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class K6 {

    private static Comparable[] aux;
    private static int cnt;

    public static void main(String[] args) {
        // 初始化画图
        StdDraw.setXscale(0, 520);
        StdDraw.setYscale(0, 33000);
        StdDraw.setPenRadius(0.002);
        // 自顶向下
//        for (int N = 1; N < 513; N++) {
//            cnt = 0;
//            Integer[] a = new Integer[N];
//            for (int i = 0; i < N; i++) {
//                a[i] = N - i;
//            }
//            sortToBottom(a);
//            StdDraw.setPenColor(StdDraw.BLACK);
//            StdDraw.point(N, cnt);
//            StdDraw.setPenColor(StdDraw.RED);
//            StdDraw.point(N, 6*N*(Math.log(N)/Math.log(2)));
//        }
        // 自底向下
        for (int N = 1; N < 513; N++) {
            cnt = 0;
            Integer[] a = new Integer[N];
            for (int i = 0; i < N; i++) {
                a[i] = N - i;
            }
            sortToUp(a);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.point(N, cnt);
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.point(N, 6*N*(Math.log(N)/Math.log(2)));
        }
    }

    public static void sortToUp(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz) {
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            cnt += 2;
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                cnt += 2;
                a[k] = aux[j++];
            } else if (j > hi) {
                cnt += 2;
                a[k] = aux[i++];
            } else if (Example.less(aux[j], aux[i])) {
                cnt += 4;
                a[k] = aux[j++];
            } else {
                cnt += 4;
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
    }
}
