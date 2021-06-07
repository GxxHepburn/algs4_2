package chaptertwo.one;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * @author gxx
 * @create 2021-06-08 5:35
 */
public class K33 {

    public static void main(String[] args) {
//        Shell shell = new Shell();
//        int T = 1000;
//        int x_scale = T+10;
//        int N = 100000;
//        sort_Pic(shell, x_scale, 1.0d/5, N, T);

//        Insertion insertion = new Insertion();
//        int T = 1000;
//        int x_scale = T+10;
//        int N = 10000;
//        sort_Pic(insertion, x_scale, 1.0d/2, N, T);

        Selection selection = new Selection();
        int T = 500;
        int x_scale = T+10;
        int N = 10000;
        sort_Pic(selection, x_scale, 1.0d/5, N, T);
    }

    public static void sort_Pic(Example example, double x_scale, double y_scale, int N, int T) {
        StdDraw.setXscale(0, x_scale);
        StdDraw.setYscale(0, y_scale);
        StdDraw.setPenRadius(0.009);

        double total = 0.0d;
        for (int i = 0; i < T; i++) {
            Double[] a = new Double[N];
            for (int j = 0; j < N; j++) {
                a[j] = StdRandom.uniform();
            }
            double time = time(a, example);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.point(i+1, time);
            total += time;
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.point(i, total/(i+1));
        }
    }

    private static double time(Double[] a, Example example) {
        Stopwatch timer = new Stopwatch();
        example.sort(a);
        return timer.elapsedTime();
    }
}
