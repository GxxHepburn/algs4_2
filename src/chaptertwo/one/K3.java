package chaptertwo.one;

import edu.princeton.cs.algs4.StdOut;

/**
 *  N   1   2   3   4   ...     N-1
 *  cnt = N^2/4
 * @author gxx
 * @create 2021-06-04 1:01
 */
public class K3 {

    public static class Index {
        int index = 0;
    }

    public static void main(String[] args) {

        int N = 10;
        int size = factorial(N);

        Integer[][] a = new Integer[size][N];
        int[] b = new int[N];
        for (int i = 0; i < N; i++) {
            b[i] = i+1;
        }
        Index index = new Index();
        index.index = 0;

        generator(0, b, N, a, index);

        Selection selection = new Selection();
        int max = 0;
        int maxIndex = 0;
        Integer[] rst = new Integer[N];
        Integer[] temp = new Integer[N];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < N; j++) {
                temp[j] = a[i][j];
            }
            int cnt = selection.sort_Return_int(a[i]);
            if (max < cnt) {
                max = cnt;
                maxIndex = i;
                rst = temp;
            }
        }

        StdOut.println("max: " + max + " , maxIndex: " + maxIndex);
        for (int i = 0; i < N; i++) {
            StdOut.print(rst[i] + " ");
        }
    }

    /**
     * 获得 N 个元素组成的不同数组共有多少个
     * @param N
     * @return
     */
    private static int factorial(int N) {
        int ans = 1;
        for (int i = 1; i <= N; i++) {
            ans *= i;
        }
        return ans;
    }

    private static Integer[][] generator(int n, int[] b, int N, Integer[][] a, Index index) {


        if (n == N) {
            for (int i = 0; i < b.length; i++) {
                a[index.index][i] = b[i];
            }
            index.index++;
        }

        for (int i = n; i < N; i++) {
            int temp = b[n];
            b[n] = b[i];
            b[i] = temp;
            generator(n+1, b, N, a, index);
            temp = b[n];
            b[n] = b[i];
            b[i] = temp;
        }
        return a;
    }

    private static void put(int[] b) {
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println( );
    }
}
