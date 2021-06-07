package chaptertwo.one;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * @author gxx
 * @create 2021-06-08 5:11
 */
public class K32 {

    public static void main(String[] args) {
        Shell shell = new Shell();
//        sort_Pic(shell, 500, 1);
        Insertion insertion = new Insertion();
//        sort_Pic(insertion, 100, 10);
        Selection selection = new Selection();
        sort_Pic(selection, 100, 10);
    }

    public static void sort_Pic(Example example, int x_scale, int y_scale) {
        int N = 1000;
        StdDraw.setXscale(0,x_scale);
        StdDraw.setYscale(0, y_scale);
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        StdDraw.setPenRadius(0.009);
        while (true) {
            Double[] a = new Double[N];
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform();
            }
            Stopwatch timer = new Stopwatch();
            example.sort(a);
            double time = timer.elapsedTime();
            N += 1000;
            System.out.println("N = " + N);
            StdDraw.point(N/1000, time);
        }
    }
}
