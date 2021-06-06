package chaptertwo.one;

import edu.princeton.cs.algs4.StdOut;

/**
 * 1、第一种方法：试图构建全排列，失败！构建全排列方式，效率太低。当N>=10时，排列数目就十分庞大了
 *      尝试着边生成边计算，跑了半个小时，也就是393
 * 2、第二种方法：(假设倒叙排列)
 *      k=N/3
 *      排列: 1, K+1, 2K+1, 2, K+2, 2k+2, ... , i, k+i, 2k+i, ... , 3k(N)
 *      本题: 1, 34, 67, 2, 35, 68, ..., 33, 66, 99, 100
 *      采用  (3^t-1)/2序列步进时（t=1,2...)，在步进长度大于 1 时发生较少变动，当步进长度等于1时，
 *      就是一般插入排序
 * 3、注意题目要求的是比较次数是尽可能的多
 * 4、通过查阅资料，发现最坏的情况~N^(3/2)
 * 5、下面实验验证
 * 6、随机生成，可以生成1000000万个试一试
 * @author gxx
 * @create 2021-06-06 22:48
 */
public class K19 {

    public static void main(String[] args) {
        int N = 99;
        int[] b = new int[N];
        int index = 0;
        for (int i = 0; i < 33; i++) {
            for (int j = 0; j < 3; j++) {
                b[index++] = i + j*33 + 1;
            }
        }
//        b[99] = 100;
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();
        int cnt = sort_Return_Cnt(b);

        StdOut.println("cnt: " + cnt + " , expected: " + Math.pow(N, 1.5));

        // 插入排序的比较次数
        index = 0;
        for (int i = 0; i < 33; i++) {
            for (int j = 0; j < 3; j++) {
                b[index++] = i + j*33 + 1;
            }
        }
//        b[99] = 100;
        cnt = sort_Return_int(b);
        StdOut.println("cnt: " + cnt + " , expected: " + Math.pow(N, 1.5));
    }

    private static int sort_Return_Cnt(int[] a) {
        int cnt = 0;
        int N = a.length;
        int h = 1;
        while (h < N/3) {
            h = 3*h + 1;
        }
        while (h >= 40) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h; j-=h) {
                    cnt++;
                    if (a[j] > a[j-h]) {
                        int temp = a[j];
                        a[j] = a[j-h];
                        a[j-h] = temp;
                    } else {
                        break;
                    }
                }
            }
            System.out.println(cnt);
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i] + " ");
            }
            h = h / 3;
        }
        return cnt;
    }

    public static int sort_Return_int(int[] a) {
        int cnt = 0;
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0; j--) {
                cnt++;
                if (a[j] > a[j-1]) {
                    int temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                } else {
                    break;
                }
            }
        }
        return cnt;
    }
}
