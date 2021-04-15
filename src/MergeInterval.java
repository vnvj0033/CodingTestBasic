import java.util.*;

public class MergeInterval {

    public static void main(String[] args) {
        Interval in1 = new Interval(1, 3);
        Interval in2 = new Interval(2, 6);
        Interval in3 = new Interval(8, 10);
        Interval in4 = new Interval(15, 18);

        List<Interval> intervals = new ArrayList<>();
        intervals.add(in1);
        intervals.add(in2);
        intervals.add(in3);
        intervals.add(in4);
        List<Interval> list = new MergeInterval().solve(intervals);

        for (Interval in : list)
            System.out.println(in.start + " " + in.end);

    }

    public List<Interval> solve(List<Interval> intervals) {
        if (intervals.isEmpty())
            return intervals;

        Collections.sort(intervals);

        List<Interval> result = new ArrayList<>();
        Interval before = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if (before.end >= current.start) {
                before.end = Math.max(current.end, before.end);
            } else {
                result.add(before);
                before = current;
            }
        }

        if (!result.contains(before))
            result.add(before);

        return result;
    }

    static class Interval implements Comparable<Interval>{
        int start;
        int end;

        Interval(int s, int e) {
            this.start = s;
            this.end = e;
        }

        @Override
        public int compareTo(Interval o) {
            return this.start - o.start;
        }
    }
}