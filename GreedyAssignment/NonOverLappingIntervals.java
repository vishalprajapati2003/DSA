package Greedy.Assignment;

import java.util.Comparator;
import java.util.Arrays;

class Interval {
    int start, end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class NonOverLappingIntervals {
    public static int RemoveOverLapping(Interval[] Intervals) {

        Arrays.sort(Intervals, (a, b) -> Integer.compare(a.start, b.start));

        int removeCount = 0;  
        int lastEndInterval = -1;
        for (int i = 0; i < Intervals.length; i++) {
            if (Intervals[i].start >= lastEndInterval) {
                lastEndInterval = Intervals[i].end;
                removeCount++;
            }
        }

        return Intervals.length - removeCount;
    }

    public static void main(String[] args) {
        Interval[] Intervals = {
                new Interval(1, 2),
                new Interval(2,3),
                new Interval(1,3),
                new Interval(1, 3)
        };

        int result = RemoveOverLapping(Intervals);
        System.out.println("Removed intervals: " + result);
    }
}
