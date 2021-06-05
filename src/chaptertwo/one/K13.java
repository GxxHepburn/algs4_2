package chaptertwo.one;

/**
 * @author gxx
 * @create 2021-06-05 16:03
 */
public class K13 {

    public static void main(String[] args) {
        int N = 52;
        RandomBag<Integer> randomBag = new RandomBag<>();
        for (int i = 0; i < N/4; i++) {
            randomBag.add(0);
            randomBag.add(1);
            randomBag.add(2);
            randomBag.add(3);
        }

        Integer[] a = new Integer[N];
        int index = 0;
        for (int i : randomBag) {
            a[index++] = i;
            System.out.println("i = " + i);
        }

        int h = 1;
        while (h < N/3) {
            h = 3*h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && Example.less(a[j], a[j-h]); j-=h) {
                    Example.exch(a, j, j-h);
                }
            }
            h = h / 3;
        }
        for (int i = 0; i < N; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
