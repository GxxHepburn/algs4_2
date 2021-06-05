package chaptertwo.one;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

/**
 * @author gxx
 * @create 2021-06-05 16:11
 */
public class RandomBag<Item> implements Iterable<Item> {

    private class Node {
        Item item;
        Node next;
    }

    private Node first;
    private int N;

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void add(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }


    @Override
    public String toString() {
        String s;
        s = "Size: " + size() + "\n";
        for (Item str : this) {
            s += (str + " ");
        }
        s += "\n";
        return s;
    }


    private class ListIterator implements Iterator<Item> {

        private int size = size();
        private int number = size;
        private Item[] a = (Item[]) new Object[size];

        public ListIterator() {
            // 用数组保存所有元素
            Node current = first;
            int index = 0;
            while (current != null) {
                a[index++] = current.item;
                current = current.next;
            }

            // 洗牌算法，等概率
            for (int i = 0; i < size; i++) {
                int r = i + StdRandom.uniform(size - i);
                Item temp = a[i];
                a[i] = a[r];
                a[r] = temp;
            }
        }

        @Override
        public boolean hasNext() {
            return number > 0;
        }

        @Override
        public Item next() {
            Item item = a[--number];
            return item;
        }
    }
}
