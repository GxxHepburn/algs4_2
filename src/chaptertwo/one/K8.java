package chaptertwo.one;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**平方级别
 * 1、只有三种值的随机数组
 * 2、最好情况：有1个1，2个2，n-2个3，那么需比较 ~N-1次，需0次交换(忽略1,2的比较和交换)
 *      所以最好的情况是线性级 ~N
 * 3、最坏情况，有n/3个1,n/3个2,n/3个3,并且交错排列,
 *      需要比较1+2+2+4+4+6+6+...+(n-2)+(n-2) ~2/3*N^2
 *      需要交换数与比较熟相等 ~2/3*N^2
 *      共需 ~4/3*N^2 次的成本
 * 3、综上，是平方级别的
 * 4、下面代码实验证明
 * @author gxx
 * @create 2021-06-05 13:02
 */
public class K8 {

    public static void main(String[] args) {
        //计算成本次数实验
//        int N = 1000;
//        Integer[] a = new Integer[N];
//        for (int i = 0; i < N; i++) {
//            a[i] = StdRandom.uniform(3);
//        }
//
//        Insertion insertion = new Insertion();
//        int cnt = insertion.sort_Return_cost(a);
//        double expect = 3*Math.pow(N,2)/4;
//        StdOut.println("cnt: " + cnt + " ,expect: " + expect
//                + " ,cnt/expect: " + cnt/expect);
        // 多次调整N的值，ratio稳定在0.22左右，实验证明是~N^2

        // 倍率实验,3/4*(2N)^2/(3/4*N^2) = 4
        int N2 = 100;
        Integer[] b= new Integer[N2];
        for (int i = 0; i < N2; i++) {
            b[i] = StdRandom.uniform(3);
        }
        Insertion insertion1 = new Insertion();
        Stopwatch timerp = new Stopwatch();
        insertion1.sort(b);
        double prev = timerp.elapsedTime();
        while (true) {
            N2 += N2;
            b = new Integer[N2];
            for (int i = 0; i < N2; i++) {
                b[i] = StdRandom.uniform(3);
            }
            insertion1 = new Insertion();
            Stopwatch timer = new Stopwatch();
            insertion1.sort(b);
            double now = timer.elapsedTime();
            StdOut.println("prev: " + prev + " , now: " + now
                            + " , now/prev: " + now/prev);
            prev = now;
        }
        // 倍率实验结果表明是~N^2,ratio约等于4
    }
}
