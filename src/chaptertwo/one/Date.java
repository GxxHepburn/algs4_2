package chaptertwo.one;

/**
 * @author gxx
 * @create 2021-06-03 15:53
 */
public class Date implements Comparable<Date> {

    private final int day;
    private final int month;
    private final int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int day() {
        return day;
    }

    public int month() {
        return month;
    }

    public int year() {
        return year;
    }

    @Override
    public int compareTo(Date that) {
        if (this.year > that.year) {
            return 1;
        }
        if (this.year < that.year) {
            return -1;
        }
        if (this.month > that.month) {
            return 1;
        }
        if (this.month < that.month) {
            return -1;
        }
        if (this.day > that.day) {
            return 1;
        }
        if (this.day < that.day) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return month + "/" + day + "/" + year;
    }
}
