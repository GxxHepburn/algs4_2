package chaptertwo.one;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author gxx
 * @create 2021-06-04 22:12
 */
public class K5 {

    public static void main(String[] args) {

        int N = 5;
        int size = factorial(N);

        Integer[][] a = new Integer[size][N];
        int[] b = new int[N];
        for (int i = 0; i < N; i++) {
            b[i] = i + 1;
        }
        Index index = new Index();
        index.index = 0;

        generator(0, b, N, a, index);

        Insertion insertion = new Insertion();
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        Integer[] rst = new Integer[N];
        Integer[] temp = new Integer[N];


        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < N; j++) {
                temp[j] = a[i][j];
            }
            int cnt = insertion.sort_Return_int(a[i]);
            if (min > cnt) {
                min = cnt;
                minIndex = i;
                for (int j = 0; j < N; j++) {
                    rst[j] = temp[j];
                }
            }
        }

        StdOut.println("min: " + min + " , minIndex: " + minIndex);
        for (int i = 0; i < N; i++) {
            StdOut.print(rst[i] + " ");
        }
    }

    public static class Index {
        int index = 0;
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
}
