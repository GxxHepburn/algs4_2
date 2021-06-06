package chaptertwo.one;

/**
 * @author gxx
 * @create 2021-06-07 2:56
 */
public class Transaction implements Comparable<Transaction> {
    private final String who;
    private final Date when;
    private final double amount;

    @Override
    public int compareTo(Transaction that) {
        if (this.amount > that.amount) {
            return +1;
        }
        if (this.amount < that.amount) {
            return -1;
        }
        return 0;
    }

    public Transaction(String who, Date when, double amount) {
        this.who = who;
        this.when = when;
        this.amount = amount;
    }

    /**
     * K19
     * @param trans
     */
    public Transaction(String trans) {
        String[] fields = trans.split(" ");
        String wo = fields[0];
        String we = fields[1];
        String a = fields[2];

        String[] dates = we.split("/");
        int m = Integer.parseInt(dates[0]);
        int d = Integer.parseInt(dates[1]);
        int y = Integer.parseInt(dates[2]);
        Date whe = new Date(y, m, d);
        double am = Double.parseDouble(a);

        this.who = wo;
        this.when = whe;
        this.amount = am;
    }

    public String who() {
        return who;
    }

    public Date when() {
        return when;
    }

    public double amount() {
        return amount;
    }

    @Override
    public String toString() {
        return who() + ", " + when() + ", " + amount();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Transaction that = (Transaction) obj;
        if (!who.equals(that.who())) {
            return false;
        }
        if (!when.equals(that.when())) {
            return false;
        }
        // 注意这里that.amount可以访问，但是建议使用amount()，这里这么做是为了说明可以做到直接访问
        if (amount != that.amount) {
            return false;
        }
        return true;
    }
}
