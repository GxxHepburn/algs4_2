package chaptertwo.two;

import chaptertwo.one.Example;
import edu.princeton.cs.algs4.In;

/**
 * 证明:
 *      数组有序时，Example.less(a[mid+1], a[mid])永远返回false，那么对
 *      数组的比较仅仅在这个条件表达式中，条件表达式的运行次数与递归sort运行次数
 *      相同，一次条件表达式需要比较1次数组元素，对于一个长度为N=2^n的数组，递归
 *      sort函数运行的次数等于递归树的节点个数，递归树的节点个数为2^(树深+1)-1,
 *      长度N=2^n的数组递归树深度为lgN-1 = n-1,节点个数为2^(n-1+1)=2^n-1=N-1,
 *      所以归并排序处理一个已经有序的数组所需的比较次数是N-1。
 *      综上，归并排序处理一个已经有序的数组所需的比较次数是线性级别的。
 *
 *  下面是实验
 * @author gxx
 * @create 2021-06-16 7:56
 */
public class K8 {

    public static int cnt;

    public static void main(String[] args) {
        int N = 1000;
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++) {
            a[i] = i;
        }
        sort(a);
        System.out.println(cnt);
    }

    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a ,0, a.length-1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        cnt++;
        if (Example.less(a[mid+1], a[mid])) {
            merge(a, lo, mid, hi);
        }
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            cnt++;
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                cnt++;
                a[k] = aux[j++];
            } else if (j > hi) {
                cnt++;
                a[k] = aux[i++];
            } else if (Example.less(aux[j], aux[i])) {
                cnt++;
                cnt++;
                a[k] = aux[j++];
            } else {
                cnt++;
                cnt++;
                a[k] = aux[i++];
            }
        }
    }
}
