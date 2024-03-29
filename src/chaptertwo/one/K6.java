package chaptertwo.one;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * 在主键都重复的情况下，插入排序更快
 *  1、逐渐都重复，所以无论是插入排序还是选择排序，都不交换元素，所以只考虑比较次数
 *  2、插入排序只比较N次。因为每一轮第一次比较时，就不满足条件，所以进入下一轮，共N次比较
 *  3、选择排序，每一轮都要扫描所有右侧元素，所以是~N^2的
 *  4、综上插入排序更快
 *
 *  下面是实验证明
 * @author gxx
 * @create 2021-06-04 23:25
 */
public class K6 {

    public static void main(String[] args) {
        int N = 150000;
        Integer[] a = new Integer[N];
        for (int i = 0; i < a.length; i++) {
            a[i] = 0;
        }

        Stopwatch timer_Insertion = new Stopwatch();
        Example insertion = new Insertion();
        insertion.sort(a);
        double t_Insertion = timer_Insertion.elapsedTime();

        Stopwatch timer_Selection = new Stopwatch();
        Example selection = new Selection();
        selection.sort(a);
        double t_Selection = timer_Selection.elapsedTime();

        StdOut.println("t_Insertion: " + t_Insertion + " , t_Selection: " + t_Selection
                + " , ratio: " + t_Selection/t_Insertion);
    }
}
