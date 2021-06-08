package chaptertwo.one;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 评估:
 *      95%有序时: 插入排序效率巨大的提升?
 *      所有元素和他们的正确位置的距离都不超过10时: 希尔排序效率大大降低，相较于选择排序、插入排序效率没有巨大提升？
 *      5%的元素随机分布在整个数组中，剩下的都是有序的时:  希尔排序效率非常高，远超过插入排序和选择排序？
 *  实验结果:
 *      95%有序时: 插入排序效率巨大的提升？    正确
 *          插入排序对优化的几种典型数组（不完整)
 *              1、数组中每个元素距离它的最终位置都不远
 *              2、一个有序的大数组接一个小数组（命中,这就是效率大幅度提高原因)
 *              3、数组中只有几个元素的位置不正确
 *
 *       所有元素和他们的正确位置的距离都不超过10时: 希尔排序效率大大降低，相较于选择排序效率没有巨大提升？    错误
 *              希尔排序仍然非常搞笑，并且随着规模扩大，效率提升越高
 *              新发现：插入排序效率大幅度提高！因为命中了插入排序优化的: 数组中每个元素距离它的最终位置都不远
 *
 *       5%的元素随机分布在整个数组中，剩下的都是有序的时:  希尔排序效率非常高，远超过插入排序和选择排序?    半对
 *              希尔排序相较于随机数组输入，效率提高两倍
 *              新发现: 插入排序效率也得到了大幅度提升。这符合插入排序的特点，对于部分有序的数组十分有效
 *
 * @author gxx
 * @create 2021-06-09 3:11
 */
public class K37 {

    public static void main(String[] args) {
        // 验证 95%有序时，插入排序效率提升巨大
//        int N = 10000;
//        while (true) {
//            Integer[] randomArray = new Integer[N];
//            for (int i = 0; i < N; i++) {
//                randomArray[i] = StdRandom.uniform(N);
//            }
//            Integer[] ntArray = getNt_Fv_Random_Pec(N);
//            double t_Nt = time("Insertion", ntArray);
//            double t_random = time("Insertion", randomArray);
//
//            StdOut.printf("For %d random Doubles\n  %s is", N, "NtArray");
//            StdOut.printf(" %.1f times faster than %s\n", t_random/t_Nt, "RandomArray");
//
//            System.out.println();
//
//            N += N;
//        }

        // 所有元素和他们的正确位置的距离都不超过10时: 希尔排序效率大大降低，相较于选择排序效率没有巨大提升
//        int N = 1000;
//        while (true) {
//            Integer[] cltArray = getCorrectLocationTen(N);
//            Integer[] temp = Arrays.copyOf(cltArray, N);
//            double t_shell = time("Shell", temp);
//            double t_selection = time("Selection", cltArray);
//
//            StdOut.printf("For %d random Doubles\n  %s is", N, "Shell");
//            StdOut.printf(" %.1f times faster than %s\n", t_selection/t_shell, "Selection");
//
//            System.out.println();
//            N += N;
//        }

        // 所有元素和他们的正确位置的距离都不超过10时,插入排序效率大幅度提高
//        int N = 1000;
//        while (true) {
//            Integer[] randomArray = new Integer[N];
//            for (int i = 0; i < N; i++) {
//                randomArray[i] = StdRandom.uniform(N);
//            }
//            Integer[] cltArray = getCorrectLocationTen(N);
//            double t_randomArray = time("Insertion", randomArray);
//            double t_clt = time("Insertion", cltArray);
//
//            StdOut.printf("For %d random Doubles\n  %s is", N, "Clt");
//            StdOut.printf(" %.1f times faster than %s\n", t_randomArray/t_clt, "RandomArray");
//
//            System.out.println();
//            N += N;
//        }

        int N = 1000;
        while (true) {

            Integer[] randomArray = new Integer[N];
            for (int i = 0; i < N; i++) {
                randomArray[i] = StdRandom.uniform(N);
            }

            Integer[] cltArray = generate95PercentSortedArray(N);
            Integer[] temp = Arrays.copyOf(cltArray, N);
            double t_shell = time("Shell", temp);
            double t_random = time("Shell", randomArray);
            temp = Arrays.copyOf(cltArray, N);
            double t_insertion = time("Insertion", temp);
            double t_selection = time("Selection", cltArray);

            StdOut.printf("For %d random Doubles\n  %s is", N, "Shell");
            StdOut.printf(" %.1f times faster than %s\n", t_random/t_shell, "RandomArray");

            StdOut.printf("For %d random Doubles\n  %s is", N, "Shell");
            StdOut.printf(" %.1f times faster than %s\n", t_insertion/t_shell, "Insertion");

            StdOut.printf("For %d random Doubles\n  %s is", N, "Shell");
            StdOut.printf(" %.1f times faster than %s\n", t_selection/t_shell, "Selection");

            System.out.println();

            N += N;
        }
    }

    /**
     * 5%的元素随机分布在整个数组中，剩下的都是有序的
     * @param N
     * @return
     */
    private static Integer[] generate95PercentSortedArray(int N) {
        Integer[] a = new Integer[N];
        int fivePercenLength = (int) (N * 0.05d);
        for (int i = 0; i < N; i++) {
            a[i] = i;
        }
        for (int i = 0; i < fivePercenLength / 2; i++) {
            int randomIndex1 = StdRandom.uniform(0, N);
            int randomIndex2 = StdRandom.uniform(0, N);

            Integer temp = a[randomIndex1];
            a[randomIndex1] = a[randomIndex2];
            a[randomIndex2] = temp;
        }
        return a;
    }

    /**
     * 所有元素和他们的正确位置的距离都不超过10时
     * @param N
     * @return
     */
    private static Integer[] getCorrectLocationTen(int N) {
        Integer[] a = new Integer[N];

        Set<Integer> generatedValues = new HashSet<>();

        for (int i = 0; i < N; i++) {
            int randomwValue = StdRandom.uniform(i - 10, i+10+1);
            while (generatedValues.contains(randomwValue)) {
                randomwValue = StdRandom.uniform(i-10, i+10+1);
            }
            generatedValues.add(randomwValue);
            a[i] = randomwValue;
        }
        return a;
    }

    /**
     * 95%有序
     * @param N
     * @return
     */
    private static Integer[] getNt_Fv_Random_Pec(int N) {
        Integer[] a = new Integer[N];

        int lastFivePercentStartIndex = (int) (N * 0.05d);
        for (int i = 0; i < N - lastFivePercentStartIndex; i++) {
            a[i] = i;
        }
        for (int i = N - lastFivePercentStartIndex; i < N; i++) {
            a[i] = StdRandom.uniform(Integer.MAX_VALUE);
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
