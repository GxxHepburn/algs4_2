package chaptertwo.two;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdRandom;


/**
 * @author gxx
 * @create 2021-06-20 16:05
 */
public class K15 {

    public static void main(String[] args) {

        int N = 10;
        Comparable[] src = new Comparable[N];
        for (int i = 0; i < N; i++) {
            src[i] = StdRandom.uniform();
        }
        Comparable[] des = mergeToUp(src);
        for (Comparable de : des) {
            System.out.println("de = " + de);
        }
    }

    public static Comparable[] mergeToUp(Comparable[] src) {
        int N = src.length;
        Queue<Queue<Comparable[]>> queues = new Queue<>();
        for (int i = 0; i < N; i++) {
            Queue<Comparable[]> queue = new Queue<>();
            Comparable[] temp = {src[i]};
            queue.enqueue(temp);
            queues.enqueue(queue);
        }
        while (queues.size() != 1) {
            Queue<Comparable[]> temp = queues.dequeue();
            Comparable[] a = temp.dequeue();

            Comparable[] b= queues.dequeue().dequeue();
            Comparable[] des = K14.mergeSorted(a, b);

            temp.enqueue(des);
            queues.enqueue(temp);
        }
        return queues.dequeue().dequeue();
    }
}
