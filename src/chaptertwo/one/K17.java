package chaptertwo.one;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author gxx
 * @create 2021-06-06 17:38
 */
public class K17 {

    public static void main(String[] args) throws InterruptedException {

        int N = 20;
        Double[] a = new Double[N];
        for (int i = 0; i < a.length; i++) {
            a[i] = StdRandom.uniform();
        }
        StdDraw.setYscale(0, 1);
        StdDraw.setXscale(0, 2*N);
        StdDraw.setPenRadius(0.002);
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
//        sort_Selection(a);
        sort_Insertion(a);
    }

    public static void sort_Selection(Comparable[] a) throws InterruptedException {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i+1; j < N; j++) {
                if (Example.less(a[j], a[min])) {
                    min = j;
                }
            }
            show(a, i, min);
            Example.exch(a, i, min);
            Thread.sleep(500);
        }
    }

    public static void sort_Insertion(Comparable[] a) throws  InterruptedException {
        int N = a.length;
        int i;
        int j = 0;
        for (i = 1; i < N; i++) {
            for (j = i; j > 0 && Example.less(a[j], a[j-1]); j--) {
                show(a, j, j-1);
                Example.exch(a, j, j-1);
                Thread.sleep(100);
            }
        }
        show(a, j-1, j);
    }

    private static void show(Comparable[] a, int cur, int min) {
        StdDraw.clear();
        for (int i = 0; i < a.length; i++) {
            if (i == cur) {
                StdDraw.setPenColor(StdDraw.BLACK);
            } else if (i == min) {
                StdDraw.setPenColor(StdDraw.RED);
            } else {
                StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
            }
            StdDraw.filledRectangle(2*i + 1, 0, 1/2.0d, (double)a[i]);
        }
    }
}
