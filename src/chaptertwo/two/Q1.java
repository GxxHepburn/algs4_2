package chaptertwo.two;

import chaptertwo.one.SortCompare;
import edu.princeton.cs.algs4.StdOut;

public class Q1 {

    public static void main(String[] args) {

        String alg1 = "Shell";
        String alg2 = "Merge";
        int N = 1000000;
        int T = 1;
        double t_Shell = SortCompare.timeRandomInput(alg1, N, T);
        double t_Merge = SortCompare.timeRandomInput(alg2, N, T);

        StdOut.printf("For %d random Doubles\n  %s is", N, alg2);
        StdOut.printf(" %.1f times faster than %s\n", t_Shell/t_Merge, alg1);
    }
}
