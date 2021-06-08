package chaptertwo.one;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author gxx
 * @create 2021-06-08 15:41
 */
public class K34 {

    public static void main(String[] args) {

//        Double[] zeroLengthArray = new Double[0];
//        Double[] oneLengthArray = new Double[1];
//        Shell shell = new Shell();
//        shell.sort(zeroLengthArray);
//        shell.sort(oneLengthArray);
//        Insertion insertion = new Insertion();
//        insertion.sort(zeroLengthArray);
//        insertion.sort(oneLengthArray);
//        Selection selection = new Selection();
//        selection.sort(zeroLengthArray);
//        selection.sort(oneLengthArray);

        int N = 1000;
        while (true) {
//            ratio(N, "Shell");
//            ratio(N, "Insertion");
            ratio(N, "Selection");
            N += N;
        }
    }

    public static void ratio(int N, String sortType) {
        Double[] randomArray = new Double[N];
        Double[] sortArray = new Double[N];
        Double[] revSortArray = new Double[N];
        Double[] identicalArray = new Double[N];
        Double[] twoValueArray = new Double[N];

        for (int i = 0; i < N; i++) {
            randomArray[i] = StdRandom.uniform();
            sortArray[i] = Double.valueOf((double)i);
            revSortArray[i] = Double.valueOf((double) (N-i));
            identicalArray[i] = 0.0d;
            twoValueArray[i] = Double.valueOf((double) StdRandom.uniform(2));
        }

        double t_random = SortCompare.time(sortType, randomArray);
        double t_sort = SortCompare.time(sortType, sortArray);
        double t_revSort = SortCompare.time(sortType, revSortArray);
        double t_identical = SortCompare.time(sortType, identicalArray);
        double t_twoValue = SortCompare.time(sortType, twoValueArray);

        StdOut.printf("For %d random Doubles\n  %s is", N, "SortArray");
        StdOut.printf(" %.1f times faster than %s\n", t_random/t_sort, "RandomArray");

        StdOut.printf("For %d random Doubles\n  %s is", N, "RevSortArray");
        StdOut.printf(" %.1f times faster than %s\n", t_random/t_revSort, "RandomArray");

        StdOut.printf("For %d random Doubles\n  %s is", N, "IdenticalArray");
        StdOut.printf(" %.1f times faster than %s\n", t_random/t_identical, "RandomArray");

        StdOut.printf("For %d random Doubles\n  %s is", N, "TwoValueArray");
        StdOut.printf(" %.1f times faster than %s\n", t_random/t_twoValue, "RandomArray");

        System.out.println();
    }
}
