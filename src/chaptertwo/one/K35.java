package chaptertwo.one;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**评估:
 *      对于所有分布，Shell 排序将比选择排序和插入排序运行得更快。
 *      选择排序将在所有分布中以相同的速度运行。
 *      插入排序在高斯分布、离散分布、几何分布、离散分布加快
 * 实验结果:
 * 一、在某一种排序实现下，五种分布的性能比较
 * 选择排序时:   高斯分布效率与随机分布效率相当，两倍于泊松分布、几何分布、离散分布
 * 插入排序时:   高斯分布效率略高于随机分布，但是比泊松分布、几何分布、离散分布慢两倍
 * 希尔排序时:   高斯分布效率与随机分布效率相当，但是比泊松分布，几何分布慢6倍，比离散分布慢10倍
 * 二、在一种分布数组中，三种排序实现的性能比较
 * 高斯分布时:   选择排序效率是插入排序的1.5倍，希尔排序效率>>插入排序和选择排序
 * 泊松分布时:   插入排序效率是选择排序的4倍，希尔排序效率>>插入排序和选择排序
 * 几何分布时:   插入排序效率是选择排序的3倍，希尔排序效率>>插入排序和选择排序
 * 离散分布时(特指):   插入排序效率是选择排序的3.4倍，希尔排序效率>>插入排序和选择排序
 * @author gxx
 * @create 2021-06-08 16:27
 */
public class K35 {

    public static void main(String[] args) {

        // 在某一种排序实现下，五种分布的性能比较
        // Shell N -> 100000
        // Insertion N -> 10000;
        // Selection N -> 10000;
//        int N = 10000;
//        while (true) {
//            ratio(N, "Shell");
//            ratio(N, "Insertion");
//            ratio(N, "Selection");
//            N += N;
//        }


        // 在一种分布数组中，三种排序实现的性能比较
        int N = 1000;
        while (true) {
//            ratio_dist(N, "Gaussian");
//            ratio_dist(N, "Poisson");
//            ratio_dist(N, "Geometric");
            ratio_dist(N, "Discrete");
            N += N;
        }
    }

    public static void ratio_dist(int N, String dist) {
        Double[] a = null;
        switch (dist) {
            case "Gaussian":
                a = getGaussianDistribution(N);
                break;
            case "Poisson":
                a = getPoissonDistribution(N);
                break;
            case "Geometric":
                a = getGeometricDistribution(N);
                break;
            case "Discrete":
                a = getdiscreteDistribution(N);
                break;
        }
        Double[] temp = Arrays.copyOf(a, a.length);
        double t_shell = SortCompare.time("Shell", temp);
        temp = Arrays.copyOf(a, a.length);
        double t_insertion = SortCompare.time("Insertion", temp);
        double t_selection = SortCompare.time("Selection", a);

        StdOut.printf("For %d random Doubles\n  %s is", N, "Shell");
        StdOut.printf(" %.1f times faster than %s\n", t_insertion/t_shell, "Insertion");

        StdOut.printf("For %d random Doubles\n  %s is", N, "Shell");
        StdOut.printf(" %.1f times faster than %s\n", t_selection/t_shell, "Selection");

        System.out.println();
    }

    public static void ratio(int N, String sortType) {
        Double[] randomArray = new Double[N];
        for (int i = 0; i < N; i++) {
            randomArray[i] = StdRandom.uniform();
        }
        Double[] gaussianArray = getGaussianDistribution(N);
        Double[] poissonArray = getPoissonDistribution(N);
        Double[] geometricArray = getGeometricDistribution(N);
        Double[] discreteArray = getdiscreteDistribution(N);

        double t_random = SortCompare.time(sortType, randomArray);
        double t_gaussian = SortCompare.time(sortType, gaussianArray);
        double t_poisson = SortCompare.time(sortType, poissonArray);
        double t_geometric = SortCompare.time(sortType, geometricArray);
        double t_discrete = SortCompare.time(sortType, discreteArray);

        StdOut.printf("For %d random Doubles\n  %s is", N, "GaussianArray");
        StdOut.printf(" %.1f times faster than %s\n", t_random/t_gaussian, "RandomArray");

        StdOut.printf("For %d random Doubles\n  %s is", N, "PoissonArray");
        StdOut.printf(" %.1f times faster than %s\n", t_random/t_poisson, "RandomArray");

        StdOut.printf("For %d random Doubles\n  %s is", N, "GeometricArray");
        StdOut.printf(" %.1f times faster than %s\n", t_random/t_geometric, "RandomArray");

        StdOut.printf("For %d random Doubles\n  %s is", N, "DiscreteArray");
        StdOut.printf(" %.1f times faster than %s\n", t_random/t_discrete, "RandomArray");

        System.out.println();
    }

    /**
     * 高斯分布，又称二项分布
     * @param N
     * @return
     */
    private static Double[] getGaussianDistribution(int N) {
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.gaussian();
        }
        return a;
    }

    private static Double[] getPoissonDistribution(int N) {
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++) {
            a[i] = 1.0d*StdRandom.poisson(0.5);
        }
        return a;
    }

    private static Double[] getGeometricDistribution(int N) {
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++) {
            a[i] = 1.0d*StdRandom.geometric(0.5);
        }
        return a;
    }

    private static Double[] getdiscreteDistribution(int N) {
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++) {
            a[i] = 1.0d*StdRandom.uniform(2);
        }
        return a;
    }
}
