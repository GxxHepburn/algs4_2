package chaptertwo.one;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gxx
 * @create 2021-06-06 15:58
 */
public class K16 {

    public static void main(String[] args) {
//        Integer[] a = {Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(2), Integer.valueOf(1)};
        String[] a = {"e", "d", "c", "b", "a"};// true true
        StdOut.println(check(a, null));
        StdOut.println(check(a, new Selection()));
    }

    private static boolean check(Comparable[] a, Example example) {
        Map<Comparable, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            int cnt = 0;
            if (map.containsKey(a[i])) {
                cnt = map.get(a[i]);
            }
            map.put(a[i], ++cnt);
        }
        if (example == null) {
            Arrays.sort(a);
        } else {
            example.sort(a);
        }
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(a[i])) {
                int cnt = map.get(a[i]);
                cnt--;
                if (cnt == 0) {
                    map.remove(a[i]);
                } else {
                    map.put(a[i], cnt);
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
