package chaptertwo.one;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;

/**
 * @author gxx
 * @create 2021-06-07 3:02
 */
public class SortTransaction {

    public static Transaction[] readTransactions() {
        Queue<String> queue = new Queue<String>();
        String trans = "";
        int t = 0;
        while (!StdIn.isEmpty()) {
            String tsstr = StdIn.readString();
            if (++t % 3 == 0) {
                trans += tsstr;
                queue.enqueue(trans);
                trans = "";
            } else {
                trans += tsstr + " ";
            }
        }
        Transaction[] tses = new Transaction[queue.size()];
        int index = 0;
        for (String str : queue) {
            tses[index++] = new Transaction(str);
        }
        return tses;
    }

    public static void main(String[] args) {
        Transaction[] transactions = readTransactions();
        new Shell().sort(transactions);
        for (Transaction transaction : transactions) {
            System.out.print(transaction);
        }
    }
}
