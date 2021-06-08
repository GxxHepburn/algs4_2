package chaptertwo.one;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

/**评估:
 *      选择排序的耗时与输入值的内容无关，不受影响。
 *      对于插入排序，以上几种情况都是重复值较多的情况，插入排序的速度会加快。
 *      希尔排序本质上也是插入排序，因此也会更快一些。
 * 实验结果:
 * 一、在某一种排序实现下，三种不均匀测试组的性能比较
 *  shuffled : false
 *      选择排序时:  三种不均匀数据稍快于随机数据（1.3~1.5倍)
 *      插入排序时:  HalfZeroHalfOne和HalfZeroQuarterOneQuarterTwo >> 随机数组
 *                  HalfZeroHalfRandom效率是 随机数组的4~5倍左右
 *      希尔排序时:  HalfZeroHalfOne和HalfZeroQuarterOneQuarterTwo效率是随机数组的50倍左右
 *                  HalfZeroHalfRandom效率是 随机数组的2.5倍左右
 *   shuffled : true
 *      选择排序时:  HalfZeroHalfOne和HalfZeroQuarterOneQuarterTwo稍快于随机数据（1.3~1.5倍)
 *                  在N < 300000时HalfZeroHalfRandom效率稍微高于随机数组
 *                  在N > 30000时HalfZeroHalfRandom效率稍低于随机数组
 *       插入排序时: 三种不均匀数组效率2倍于随机数组
 *       希尔排序:  HalfZeroHalfOne和HalfZeroQuarterOneQuarterTwo效率开始时几十倍于随机数组，并且一直在升高
 *                  HalfZeroHalfRandom效率是 随机数组的2倍左右
 * 二、在一种不均匀测试组中，三种排序实现的性能比较
 *  shuffled : false
 *      HalfZeroHalfOne时:   希尔排序于插入排序效率基本相同 >> 选择排序
 *      HalfZeroQuarterOneQuarterTwo时:      希尔排序于插入排序效率基本相同 >> 选择排序
 *      HalfZeroHalfRandom时:        插入排序效率是选择排序的2倍左右，在N到达150000是，趋近，随后选择排序效率稍超过插入排序
 *                                  希尔排序效率 >> 插入排序和选择排序并且持续升高
 *  shuffled : true
 *      HalfZeroHalfOne时:   希尔排序效率 >> 插入排序和选择排序并且持续升高
 *                           插入排序效率是选择排序的2.5~3倍左右
 *      HalfZeroQuarterOneQuarterTwo时:  希尔排序效率 >> 插入排序和选择排序并且持续升高
 *                                          插入排序效率是选择排序的2倍左右
 *      HalfZeroHalfRandom时:    希尔排序效率 >> 插入排序和选择排序并且持续升高
 *                                  插入排序效率稍高于选择排序的
 * @author gxx
 * @create 2021-06-08 18:39
 */
public class K36 {

    public static void main(String[] args) {

        // 在某一种排序实现下，三种不均匀数组的性能比较
//        int N = 10000;
//        while (true) {
//            ratio(N, "Selection", false);
//            ratio(N, "Insertion", false);
//            ratio(N, "Shell", false);
//            ratio(N, "Selection", true);
//            ratio(N, "Insertion", true);
//            ratio(N, "Shell", true);
//            N += N;
//        }

        // 在一种不均匀数组中，三种排序实现的性能比较
        int N = 10000;
        while (true) {
//            ratio_dist(N, "HalfZeroHalfOne", false);
//            ratio_dist(N, "HalfZeroQuarterOneQuarterTwo", false);
//            ratio_dist(N, "HalfZeroHalfRandom", false);
//            ratio_dist(N, "HalfZeroHalfOne", true);
//            ratio_dist(N, "HalfZeroQuarterOneQuarterTwo", true);
            ratio_dist(N, "HalfZeroHalfRandom", true);
            N += N;
        }
    }

    public static void ratio_dist(int N, String dist, boolean shuffled) {
        Integer[] a = null;
        switch (dist) {
            case "HalfZeroHalfOne":
                a = getHalfZeroHalfOne(N, shuffled);
                break;
            case "HalfZeroQuarterOneQuarterTwo":
                a = getHalfZeroQuarterOneQuarterTwo(N, shuffled);
                break;
            case "HalfZeroHalfRandom":
                a = getHalfZeroHalfRandom(N, shuffled);
                break;
        }
        Integer[] temp = Arrays.copyOf(a, a.length);
        double t_shell = time("Shell", temp);
        temp = Arrays.copyOf(a, a.length);
        double t_insertion = time("Insertion", temp);
        double t_selection = time("Selection", a);

        StdOut.printf("For %d random Doubles\n  %s is", N, "Shell");
        StdOut.printf(" %.1f times faster than %s\n", t_insertion/t_shell, "Insertion");

        StdOut.printf("For %d random Doubles\n  %s is", N, "Shell");
        StdOut.printf(" %.1f times faster than %s\n", t_selection/t_shell, "Selection");

        System.out.println();
    }

    public static void ratio(int N, String sortType, boolean shuffled) {
        Integer[] randomArray = new Integer[N];
        for (int i = 0; i < N; i++) {
            randomArray[i] = StdRandom.uniform(N);
        }
        Integer[] halfZeroHalfOneArray = getHalfZeroHalfOne(N, shuffled);
        Integer[] halfZeroQuarterOneQuarterTwoArray = getHalfZeroQuarterOneQuarterTwo(N, shuffled);
        Integer[] halfZeroHalfRandomArray = getHalfZeroHalfRandom(N, shuffled);

        double t_random = time(sortType, randomArray);
        double t_halfZeroHalfOne = time(sortType, halfZeroHalfOneArray);
        double t_halfZeroQuarterOneQuarterTwo = time(sortType, halfZeroQuarterOneQuarterTwoArray);
        double t_halfZeroHalfRandom = time(sortType, halfZeroHalfRandomArray);

        StdOut.printf("For %d random Doubles\n  %s is", N, "HalfZeroHalfOne");
        StdOut.printf(" %.1f times faster than %s\n", t_random/t_halfZeroHalfOne, "RandomArray");

        StdOut.printf("For %d random Doubles\n  %s is", N, "HalfZeroQuarterOneQuarterTwo");
        StdOut.printf(" %.1f times faster than %s\n", t_random/t_halfZeroQuarterOneQuarterTwo, "RandomArray");

        StdOut.printf("For %d random Doubles\n  %s is", N, "HalfZeroHalfRandom");
        StdOut.printf(" %.1f times faster than %s\n", t_random/t_halfZeroHalfRandom, "RandomArray");

        System.out.println();
    }

    private static Integer[] getHalfZeroHalfOne(int N, boolean shuffled) {
        Integer[] a = new Integer[N];
        int half = N / 2;
        for (int i = 0; i < half; i++) {
            a[i] = 0;
        }
        for (int i = half; i < a.length; i++) {
            a[i] = 1;
        }
        if (shuffled) {
            StdRandom.shuffle(a);
        }
        return a;
    }

    /**
     * 函数名有错误，应该是1/2 1/4 1/8... 1
     * @param N
     * @param shuffled
     * @return
     */
    private static Integer[] getHalfZeroQuarterOneQuarterTwo(int N, boolean shuffled) {
        Integer[] a = new Integer[N];
        int start = 0;
        int end = N / 2;
        int index = 0;
        int cur = 0;
        while (end < N) {
            for (int i = index; i < end; i++) {
                a[i] = cur;
                index++;
            }
            cur++;
            start = index;
            if (N-start == 1) {
                end = start+1;
            } else {
                end = start + (N-start) / 2;
            }
        }
        a[N-1] = cur;
        if (shuffled) {
            StdRandom.shuffle(a);
        }
        return a;
    }

    private static Integer[] getHalfZeroHalfRandom(int N, boolean shuffled) {
        Integer[] a = new Integer[N];
        int half = N / 2;
        for (int i = 0; i < half; i++) {
            a[i] = 0;
        }
        for (int i = half; i < a.length; i++) {
            a[i] = StdRandom.uniform(N);
        }
        if (shuffled) {
            StdRandom.shuffle(a);
        }
        return a;
    }

    public static double time(String alg, Integer[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion")) {
            new Insertion().sort(a);
        }
        if (alg.equals("Selection")) {
            new Selection().sort(a);
        }
        if (alg.equals("Shell")) {
            new Shell().sort(a);
        }
        if (alg.equals("K24")) {
            new K24().sort(a);
        }
        if (alg.equals("K25")) {
            new K25().sort(a);
        }
        return  timer.elapsedTime();
    }
}
