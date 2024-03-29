package chaptertwo.one;

/**
 * @author gxx
 * @create 2021-06-03 22:10
 */
public class Shell extends Example {

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N/3) {
            h = 3*h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j-h]); j-=h) {
                    exch(a, j, j-h);
                }
            }
            h = h / 3;
        }
    }

    public static int sort_Return_Cnt(Comparable[] a) {
        int cnt = 0;
        int N = a.length;
        int h = 1;
        while (h < N/3) {
            h = 3*h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h; j-=h) {
                    cnt++;
                    if (less(a[j], a[j-h])) {
                        exch(a, j, j-h);
                    } else {
                        break;
                    }
                }
            }
            h = h / 3;
        }
        return cnt;
    }
}
