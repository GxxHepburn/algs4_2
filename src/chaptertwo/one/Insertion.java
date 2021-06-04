package chaptertwo.one;

/**
 * @author gxx
 * @create 2021-06-03 17:25
 */
public class Insertion extends Example {

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
        }
    }

    public int sort_Return_int(Comparable[] a) {
        int cnt = 0;
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
                cnt++;
            }
        }
        return cnt;
    }
}
