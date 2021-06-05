package chaptertwo.one;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author gxx
 * @create 2021-06-05 15:54
 */
public class K12 {

    public static void main(String[] args) {
        int N = 10;
        while (true) {
            N *= 10;
            ratio(N);
        }
    }

    private static void ratio(int N) {
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform();
        }

        int h = 1;
        while (h < N/3) {
            h = 3*h +1;
        }

        while (h >= 1) {
            int cnt = 0;
            for (int i = h; i < N; i++) {
                cnt++;
                for (int j = i; j >= h && Example.less(a[j], a[j-h]); j-=h){
                    Example.exch(a, j, j-h);
                }
            }
            h = h / 3;
            StdOut.println("cnt: " + cnt + " , N: " + N
                    + " , cnt/N: " + cnt*1.0d/N);
        }
    }
}
