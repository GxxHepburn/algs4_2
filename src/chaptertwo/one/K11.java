package chaptertwo.one;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gxx
 * @create 2021-06-05 15:19
 */
public class K11 {

    public static void main(String[] args) {
        Integer[] a = {5, 4, 3, 2, 1};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        while (h < N/3) {
            h = 3*h + 1;
            list.add(h);
        }
        int[] hArray = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            hArray[i] = list.get(i);
        }
        int index = hArray.length-1;
        while (index >= 0) {
            h = hArray[index--];
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && Example.less(a[j], a[j-h]); j-=h) {
                    Example.exch(a, j, j-h);
                }
            }
        }
    }
}
