package chaptertwo.one;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.HashMap;
import java.util.Map;

/**
 * t 从2开始   0.1 递增
 *      第一名是 2.1 递增序列为  1   2   4   8   16  32  65....
 *          总时间是4.674
 *      第二名是 2.5    递增序列是   1   2   6   15....
 *          总时间是5.064
 *      第三名是 2.3    递增序列是   1   2   5   12....
 *          总时间是5.076
 *
 * t 从而开始   0.01 递增
 *      第一名是 2.13 递增序列为     1   2   4   9....
 *          总时间是4.702
 *      第二名是 2.25 递增序列为     1   2   5   11  25....
 *          总时间是4.763
 *      第三名是 2.23 递增序列为     1   2   4   11  24....
 *          总时间是4.778
 * @author gxx
 * @create 2021-06-07 21:40
 */
public class K30 {

    public static void main(String[] args) {

        Map<Double, Double> map = new HashMap<>();

        // 对于每一种序列，进行T遍测试，算出总时间
        time(map);
    }

    private static void time(Map<Double, Double> map) {
        // N从10000开始，倍增至10^6
        int N = 10000;
        int T = 5;
        // 从2开始，每次递增0.01尝试
        double t = 2;
        double min = Double.MAX_VALUE;
        while (t < 1000) {
            double total = 0.0d;
            N = 10000;
            while (N <= 1000000) {
                Double[] a = new Double[N];
                for (int i = 0; i < T; i++) {
                    for (int j = 0; j < N; j++) {
                        a[j] = StdRandom.uniform();
                    }
                    total += time(a, t);
                }
                N += N;
            }
            StdOut.println("t: " + t + " , total: " + total);
            map.put(t, total);
            if (min > total) {
                min = total;
                StdOut.println("t: " + t + " , min: " + min);
            }
            t += 0.01;
        }
    }

    private static double time(Comparable[] a, Double t) {
        Stopwatch timer = new Stopwatch();
        sort(a, t);
        return timer.elapsedTime();
    }

    private static void sort(Comparable[] a, Double t) {
        int N = a.length;
        int index = 0;
        while (Math.floor(Math.pow(t, index)) <= N) {
            index++;
        }
        index--;
        while (index >= 0) {
            int h = (int) Math.floor(Math.pow(t, index));
            for (int i = h; i <N ; i++) {
                for (int j = i; j >=h && Example.less(a[j], a[j-h]); j-=h) {
                    Example.exch(a, j ,j-h);
                }
            }
            index--;
        }
    }
}
