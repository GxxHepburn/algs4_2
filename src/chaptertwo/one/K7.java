package chaptertwo.one;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * 对于逆序数组，选择排序更快
 * 1、插入排序需要比较   1+2+3+...+(n-1)=n(n-1)/2 ~N^2/2
 * 2、插入排序需要交换   1+2+3+...+(n-1)=n(n-1)/2 ~N^2/2
 * 3、选择排序需要比较   (n)+(n-1)+...+1=n(n+1)/2 ~N^2/2
 * 4、选择排序需要交换   1+1+...+1=n N
 * 5、综合比较和交换的次数，选择排序更快
 * 6、下面代码将实验证明
 * @author gxx
 * @create 2021-06-05 12:44
 */
public class K7 {

    public static void main(String[] args) {
        int N = 100000;
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++) {
            a[i] = N-i;
        }

        Stopwatch timer_Insertion = new Stopwatch();
        Example insertion = new Insertion();
        insertion.sort(a);
        double t_Insertion = timer_Insertion.elapsedTime();

        for (int i = 0; i < N; i++) {
            a[i] = N-i;
        }

        Stopwatch timer_Selection = new Stopwatch();
        Example selection = new Selection();
        selection.sort(a);
        double t_Selection = timer_Selection.elapsedTime();

        StdOut.println("t_Insertion: " + t_Insertion + " , t_Selection: " +
                t_Selection + " , insertion/selection: " +
                t_Insertion/t_Selection);
    }
}
