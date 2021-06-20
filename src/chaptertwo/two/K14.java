package chaptertwo.two;

import chaptertwo.one.Example;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author gxx
 * @create 2021-06-20 15:50
 */
public class K14 {

    public static void main(String[] args) {

        int N = 10;
        int M = 6;
        Comparable[] a = new Comparable[N];
        Comparable[] b= new Comparable[M];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform();
        }
        for (int i = 0; i < M; i++) {
            b[i] = StdRandom.uniform();
        }
        Merge.sort(a);
        Merge.sort(b);
        Comparable[] des = mergeSorted(a, b);
        for (Comparable de : des) {
            System.out.println("de = " + de);
        }
    }

    public static Comparable[] mergeSorted(Comparable[] a, Comparable[] b) {
        int N = a.length;
        int M = b.length;
        Comparable[] des = new Comparable[N +  M];
        int i = 0;
        int j = 0;
        for (int k = 0; k < N + M; k++) {
            if (i >= N) {
                des[k] = b[j++];
            } else if (j >= M) {
                des[k] = a[i++];
            } else if (Example.less(a[i], b[j])) {
                des[k] = a[i++];
            } else {
                des[k] = a[j++];
            }
        }
        return des;
    }
}
