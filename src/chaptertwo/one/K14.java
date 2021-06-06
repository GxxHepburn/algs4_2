package chaptertwo.one;

import edu.princeton.cs.algs4.StdOut;

/**
 * 1、选择排序算法，即每次选出该扑克牌中最大的那个牌出来
 * 2、比较最上面的两张牌，如果第一张牌比第二张牌大，就交换这两张牌，
 *      否则保持这两张牌的顺序不变，然后再将第一张牌放入牌底，
 *      随着是同样的操作——比较最上面的两张牌。经过length-1次这样的操作后，
 *      最上面的牌肯定是最大的一张牌了，此时不需要做任何的比较，直接把此牌放入牌底。
 * 3、第一步中已经找出了最大的一张牌并且放入了牌底，那么接下来还是同样的做法，
 *      就是在最上面的length-1张牌中，找出最大的一张牌，再放入排序，
 *      经过反复的这样操作后，可以实现有序，最大的牌在最上面，而最小的牌在最下面。
 * @author gxx
 * @create 2021-06-06 14:38
 */
public class K14 {

    public static void main(String[] args) {
        int N = 52;
        RandomBag<Integer> randomBag = new RandomBag<>();
        for (int i = 0; i < N / 4; i++) {
            randomBag.add(0);
            randomBag.add(1);
            randomBag.add(2);
            randomBag.add(3);
        }

        Steque<Integer> steque = new Steque<>();
        for (int i : randomBag) {
            steque.enqueue(i);
        }

        for (int i = 1; i < steque.size()-1; i++) {
            for (int j = 0; j < steque.size()-i; j++) {
                int first = steque.pop();
                int second = steque.pop();
                steque.enqueue(Math.min(first, second));
                steque.push(Math.max(first, second));
            }
            for (int j = 0; j < i; j++) {
                steque.enqueue(steque.pop());
            }
        }
        StdOut.println(steque.toString());
    }
}
