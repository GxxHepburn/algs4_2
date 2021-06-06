package chaptertwo.one;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author gxx
 * @create 2021-06-07 0:08
 */
public class K19_test {

    public static void main(String[] args) {
        int[] a = {1, 4, 7, 2, 5, 8, 3, 6, 9, 10};
        StdOut.println(sort_Return_Cnt(a));
    }

    public static int sort_Return_Cnt(int[] a) {
        int cnt = 0;
        int N = a.length;
        int h = 1;
        while (h < N/3) {
            h = 3*h + 1;
        }
        int prev = 0;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h; j-=h) {
                    cnt++;
                    if (a[j] < a[j-h]) {
                        int temp = a[j];
                        a[j] = a[j-h];
                        a[j-h] = temp;
                    } else {
                        break;
                    }
                }
                StdOut.println("cnt: " + (cnt-prev));
                prev = cnt;
            }
            h = h / 3;
        }
        return cnt;
    }
}
