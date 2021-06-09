package chaptertwo.one;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.HashMap;
import java.util.Map;

/**
 * 评估:
 *      String类型主键提高了比较成本？
 *      元素变复杂并不会提高交换成本，因为仅仅是交换引用？
 *
 *  实验结果:
 *      String类型主键提高了比较成本？  正确
 *          希尔排序时，基本数据类型主键效率>>String类型主键
 *          选择排序时，基本数据类型主键效率10~ 倍于String类型主键,并且继续缓慢提高
 *          插入排序时，基本数据类型主键效率10~ 倍于String类型主键,并且继续缓慢提高
 *      元素变复杂并不会提高交换成本，因为仅仅是交换引用？   还是有影响的
 *          Int主键
 *              希尔排序时，基本数据类型主键效率>>int类型主键
 *                  因为采用map存储，所以取key值时成本较大,主要原因还是因为希尔排序本身原因(N值越大，效率越高)
 *              插入排序时，基本数据类型主键效率30 倍于int类型主键,证明了评估猜想
 *              选择排序时, 基本数据类型主键效率20 倍于int类型主键,证明了评估猜想
 *          Double主键
 *              希尔排序时，基本数据类型主键效率>>Double类型主键
 *                  因为采用map存储，所以取key值时成本较大,主要原因还是因为希尔排序本身原因(N值越大，效率越高)
 *              插入排序时，基本数据类型主键效率30 倍于Double类型主键,证明了评估猜想
 *              选择排序时, 基本数据类型主键效率25~30 倍于Double类型主键,证明了评估猜想
 *
 *
 *
 * @author gxx
 * @create 2021-06-09 5:56
 */
public class K38 {

    public static void main(String[] args) {
        // String类型主键提高了比较成本
//        int N = 1000;
//        while (true) {
//            Double[] a = new Double[N];
//            for (int i = 0; i < N; i++) {
//                a[i] = StdRandom.uniform();
//            }
//            Map[] b = generateStringKeyDoubleValueArray(N);
//            double t_double_Shell = time("Insertion", a);
//            double t_map_Shell = time_keyString("Insertion", b);
//
//            StdOut.printf("For %d random Doubles\n  %s is", N, "Double");
//            StdOut.printf(" %.1f times faster than %s\n", t_map_Shell/t_double_Shell, "Map");
//
//            System.out.println();
//            N += N;
//        }

        // 元素变复杂并不会提高交换成本，因为仅仅是交换引用？
        // int主键
//        int N = 1000;
//        while (true) {
//            Double[] a = new Double[N];
//            for (int i = 0; i < N; i++) {
//                a[i] = StdRandom.uniform();
//            }
//            Map[] b = generateIntKeyIntArrayValuesArray(N);
//            double t_double_Shell = time("Selection", a);
//            double t_map_Shell = time_keyInt("Selection", b);
//
//            StdOut.printf("For %d random Doubles\n  %s is", N, "Int");
//            StdOut.printf(" %.1f times faster than %s\n", t_map_Shell/t_double_Shell, "Map");
//
//            System.out.println();
//            N += N;
//        }

        // Double主键
        int N = 1000;
        while (true) {
            Double[] a = new Double[N];
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform();
            }
            Map[] b = generateDoubleKeyStringValuesArray(N);
            double t_double_Shell = time("Selection", a);
            double t_map_Shell = time_keyDouble("Selection", b);

            StdOut.printf("For %d random Doubles\n  %s is", N, "Double");
            StdOut.printf(" %.1f times faster than %s\n", t_map_Shell/t_double_Shell, "Map");

            System.out.println();
            N += N;
        }
    }

    /**
     * 每个元素主键均为int类型，并含有一个int[20]值
     * @param N
     * @return
     */
    private static Map[] generateIntKeyIntArrayValuesArray(int N) {
        Map[] a = new HashMap[N];

        for (int i = 0; i < N; i++) {
            Map<Integer, int[]> keyValues = new HashMap<>();
            int randomKey = StdRandom.uniform(Integer.MAX_VALUE);
            int[] randomValue = new int[20];
            for (int j = 0; j < randomValue.length; j++) {
                randomValue[j] = StdRandom.uniform(Integer.MAX_VALUE);
            }
            keyValues.put(randomKey, randomValue);
            a[i] = keyValues;
        }
        return a;
    }

    /**
     * 每个元素的主键均为double类型，并含有10个String值(每个都至少长10个字符)
     * @param N
     * @return
     */
    private static Map[] generateDoubleKeyStringValuesArray(int N) {
        Map[] a = new HashMap[N];

        for (int i = 0; i < N; i++) {
            Map<Double, String[]> keyValues = new HashMap<>();
            double randomKey = StdRandom.uniform();
            String[] randomValue = new String[10];
            for (int j = 0; j < randomValue.length; j++) {
                randomValue[j] = generate10CharRandomString();
            }

            keyValues.put(randomKey, randomValue);
            a[i] = keyValues;
        }
        return a;
    }

    /**
     * 每个元素的主键均为String类型( 至少长10个字符 ),并含有一个double值
     * @param N
     * @return
     */
    private static Map[] generateStringKeyDoubleValueArray(int N) {
        Map[] a = new HashMap[N];

        for (int i = 0; i < N; i++) {
            Map<String, Double> keyValues = new HashMap<>();

            String randomKey = generate10CharRandomString();
            double randomValue = StdRandom.uniform();

            keyValues.put(randomKey, randomValue);
            a[i] = keyValues;
        }
        return a;
    }

    private static String generate10CharRandomString() {
        int N = StdRandom.uniform(10, 15);
        char[] chars = new char[N];
        for (int i = 0; i < chars.length; i++) {
            int randomCharIntValue = StdRandom.uniform(65, 122+1);
            while (randomCharIntValue >= 91 && randomCharIntValue <= 96) {
                randomCharIntValue = StdRandom.uniform(65, 122+1);
            }
            char randomCharValue = (char) randomCharIntValue;
            chars[i] = randomCharValue;
        }
        return String.valueOf(chars);
    }

    public static double time(String alg, Comparable[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion")) {
            new Insertion().sort(a);
        }
        if (alg.equals("Selection")) {
            new Selection().sort(a);
        }
        if (alg.equals("Shell")) {
            new Shell().sort(a);
        }
        if (alg.equals("K24")) {
            new K24().sort(a);
        }
        if (alg.equals("K25")) {
            new K25().sort(a);
        }
        return  timer.elapsedTime();
    }

    public static double time_keyString(String alg, Map[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion")) {
            int N = a.length;
            for (int i = 1; i < N; i++) {
                for (int j = i; j > 0; j--) {
                    String jk1 = "";
                    for (Object key : a[j].keySet()) {
                        jk1 = (String) key;
                    }
                    String jk2 = "";
                    for (Object key : a[j-1].keySet()) {
                        jk2 = (String) key;
                    }
                    if (Example.less(jk1, jk2)) {
                        Map temp = a[j];
                        a[j] = a[j-1];
                        a[j-1] = temp;
                    }
                }
            }
        }
        if (alg.equals("Selection")) {
            int N = a.length;
            for (int i = 0; i < N; i++) {
                int min = i;
                for (int j = i+1; j < N; j++) {
                    String jk1 = "";
                    for (Object key : a[j].keySet()) {
                        jk1 = (String) key;
                    }
                    String jk2 = "";
                    for (Object key : a[min].keySet()) {
                        jk2 = (String) key;
                    }
                    if (Example.less(jk1, jk2)) {
                        min = j;
                    }
                }
                Map temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }
        if (alg.equals("Shell")) {
            int N = a.length;
            int h = 1;
            while (h < N/3) {
                h = 3*h + 1;
            }
            while (h >= 1) {
                for (int i = h; i < N; i++) {
                    for (int j = i; j >= h; j-=h) {
                        String jk1 = "";
                        for (Object key : a[j].keySet()) {
                            jk1 = (String) key;
                        }
                        String jk2 = "";
                        for (Object key : a[j-h].keySet()) {
                            jk2 = (String) key;
                        }
                        if (Example.less(jk1, jk2)) {
                            Map temp = a[j];
                            a[j] = a[j-h];
                            a[j-h] = temp;
                        }
                    }
                }
                h = h / 3;
            }
        }
        return timer.elapsedTime();
    }

    public static double time_keyInt(String alg, Map[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion")) {
            int N = a.length;
            for (int i = 1; i < N; i++) {
                for (int j = i; j > 0; j--) {
                    int jk1 = 0;
                    for (Object key : a[j].keySet()) {
                        jk1 = (int) key;
                    }
                    int jk2 = 0;
                    for (Object key : a[j-1].keySet()) {
                        jk2 = (int) key;
                    }
                    if (Example.less(jk1, jk2)) {
                        Map temp = a[j];
                        a[j] = a[j-1];
                        a[j-1] = temp;
                    }
                }
            }
        }
        if (alg.equals("Selection")) {
            int N = a.length;
            for (int i = 0; i < N; i++) {
                int min = i;
                for (int j = i+1; j < N; j++) {
                    int jk1 = 0;
                    for (Object key : a[j].keySet()) {
                        jk1 = (int) key;
                    }
                    int jk2 = 0;
                    for (Object key : a[min].keySet()) {
                        jk2 = (int) key;
                    }
                    if (Example.less(jk1, jk2)) {
                        min = j;
                    }
                }
                Map temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }
        if (alg.equals("Shell")) {
            int N = a.length;
            int h = 1;
            while (h < N/3) {
                h = 3*h + 1;
            }
            while (h >= 1) {
                for (int i = h; i < N; i++) {
                    for (int j = i; j >= h; j-=h) {
                        int jk1 = 0;
                        for (Object key : a[j].keySet()) {
                            jk1 = (int) key;
                        }
                        int jk2 = 0;
                        for (Object key : a[j-h].keySet()) {
                            jk2 = (int) key;
                        }
                        if (Example.less(jk1, jk2)) {
                            Map temp = a[j];
                            a[j] = a[j-h];
                            a[j-h] = temp;
                        }
                    }
                }
                h = h / 3;
            }
        }
        return timer.elapsedTime();
    }

    public static double time_keyDouble(String alg, Map[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion")) {
            int N = a.length;
            for (int i = 1; i < N; i++) {
                for (int j = i; j > 0; j--) {
                    Double jk1 = 0d;
                    for (Object key : a[j].keySet()) {
                        jk1 = (Double) key;
                    }
                    Double jk2 = 0d;
                    for (Object key : a[j-1].keySet()) {
                        jk2 = (Double) key;
                    }
                    if (Example.less(jk1, jk2)) {
                        Map temp = a[j];
                        a[j] = a[j-1];
                        a[j-1] = temp;
                    }
                }
            }
        }
        if (alg.equals("Selection")) {
            int N = a.length;
            for (int i = 0; i < N; i++) {
                int min = i;
                for (int j = i+1; j < N; j++) {
                    Double jk1 = 0d;
                    for (Object key : a[j].keySet()) {
                        jk1 = (Double) key;
                    }
                    Double jk2 = 0d;
                    for (Object key : a[min].keySet()) {
                        jk2 = (Double) key;
                    }
                    if (Example.less(jk1, jk2)) {
                        min = j;
                    }
                }
                Map temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }
        if (alg.equals("Shell")) {
            int N = a.length;
            int h = 1;
            while (h < N/3) {
                h = 3*h + 1;
            }
            while (h >= 1) {
                for (int i = h; i < N; i++) {
                    for (int j = i; j >= h; j-=h) {
                        Double jk1 = 0d;
                        for (Object key : a[j].keySet()) {
                            jk1 = (Double) key;
                        }
                        Double jk2 = 0d;
                        for (Object key : a[j-h].keySet()) {
                            jk2 = (Double) key;
                        }
                        if (Example.less(jk1, jk2)) {
                            Map temp = a[j];
                            a[j] = a[j-h];
                            a[j-h] = temp;
                        }
                    }
                }
                h = h / 3;
            }
        }
        return timer.elapsedTime();
    }
}
