package chaptertwo.two;

import chaptertwo.one.Example;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 分析:
 *      最坏情况:
 *          数组为逆序时，可以确保参与第一轮的归并的所有子数组的长度均为1,时此即为最坏情况。
 *          设数组长度为N=2^n,那么归并树深度为n,每一层查找子数组需要进行2N次数组访问，
 *          每一层归并需要2N次数组访问完成复制到辅助数组的操作，需要2N次数组访问完成比较，
 *          需要2N次访问完成辅助数组到a数组的复制，那么从底向上的自然归并最坏情况下
 *          需要访问8NlgN次数组。
 *      最长子数组为K时:
 *          数组的最长子数组为k时，的最好情况是第一轮的所有子数组的长度均为k,
 *          设数组长度为N=K*2^m,那么归并树深库为m,每一层查找子数组需要进行2N次数组访问，
 *          每一层归并需要2N次数组访问完成复制到辅助数组的操作，需要2N次数组访问完成比较，
 *          需要2N次访问完成辅助数组到a数组的复制，那么从底向上的自然归并最坏情况下
 *          需要访问8Nlg(N/k)次数组操作。
 *
 * @author gxx
 * @create 2021-06-20 16:42
 */
public class K16 {

    public static void main(String[] args) {

        int N = 1000;
        Comparable[] a = new Comparable[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(10);
        }
        for (Comparable comparable : a) {
            System.out.println("comparable = " + comparable);
        }
        sort(a);
        for (Comparable comparable : a) {
            System.out.println("comparable = " + comparable);
        }
    }

    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];

        while (true) {
            int arrayN = 0;
            int i = 0;
            int j = 0;
            while (j < N && i < N) {
                int k = i;
                while (k+1 < N && !Example.less(a[k+1], a[k])) {
                    k++;
                }
                if (k > i) {
                    arrayN++;
                }
                j = k;
                k = k+1;
                while (k < N && k+1 < N && !Example.less(a[k+1], a[k])) {
                    k++;
                }
                
                if (k >= N) {
                    break;
                }
                arrayN++;
                // 归并数组
                merge(a, i, j, k);
                i = k+1;
            }
            if (arrayN == 1) {
                break;
            }
        }
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (Example.less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }
}
