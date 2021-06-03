package chaptertwo.one;

import edu.princeton.cs.algs4.In;

/**
 * @author gxx
 * @create 2021-06-03 15:00
 */
public abstract class Example {


    public static void main(String[] args) {
        String[] a = In.readStrings();
        //选择排序
//        Example selection = new Selection();
//        test(selection, a);
        //插入排序
        Example insertion = new Insertion();
        test(insertion, a);
    }

    public static void test(Example example, Comparable[] a) {
        example.sort(a);
        assert example.isSorted(a);
        example.show(a);
    }

    public abstract void sort(Comparable[] a);

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i] + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i-1])) {
                return false;
            }
        }
        return true;
    }
}
