package chaptertwo.one;

/**
 * @author gxx
 * @create 2021-06-03 17:07
 */
public class Selection extends Example {

    public void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i+1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }

    // K3
    public int sort_Return_int(Comparable[] a) {
        int cnt = 0;
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i+1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                    cnt++;
                }
            }
            exch(a, i, min);
        }
        return cnt;
    }
}
