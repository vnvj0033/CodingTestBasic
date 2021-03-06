package string;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 미팅룸 시간이 주어질때 미팅룸 하나에 예약이 가능한지
 *
 * input :
 *     in1 = new Interval(15, 20);
 *     in2 = new Interval(5, 10);
 *     in3 = new Interval(0, 30);
 *
 * output : false
 * */

public class MeetingRooms {
    public static void main(String[] args) {
        MeetingRooms a = new MeetingRooms();

        Interval in1 = new Interval(15, 20);
        Interval in2 = new Interval(5, 10);
        Interval in3 = new Interval(0, 30);

        Interval[] intervals = {in1, in2, in3};
        System.out.println(a.solve(intervals));

    }

    public boolean solve(Interval[] intervals) {
        if (intervals == null) return false;

        Arrays.sort(intervals);

        for (int i = 1; i < intervals.length; i++)
            if (intervals[i - 1].end > intervals[i].start)
                return false;

        return true;
    }

    private static class Interval implements Comparable<Interval>{
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