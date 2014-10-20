package undone;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/*
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 */
class Interval {
  int start;
  int end;
  Interval() { start = 0; end = 0; }
  Interval(int s, int e) { start = s; end = e; }
  @Override
  public String toString() {
    return "[" + start + "," + end + "]";
  }
}

public class MergeIntervals {
  public List<Interval> merge(List<Interval> intervals) {
    Collections.sort(intervals, new Comparator<Interval>() {
      @Override
      public int compare(Interval o1, Interval o2) {
        return o1.start - o2.start;
      }
    });

    for(int i=0; i<intervals.size()-1; i++) {
      while(i + 1 < intervals.size() && intervals.get(i).end >= intervals.get(i + 1).start) {
        if(intervals.get(i).end < intervals.get(i + 1).end)
          intervals.get(i).end = intervals.get(i + 1).end;
        intervals.remove(i + 1);
      }
    }
    return intervals;
  }

  public static void main(String args[]) {
    List<Interval> intervals = new LinkedList<Interval>();
    intervals.add(new Interval(1, 4));
    intervals.add(new Interval(2, 3));
    Object result = new MergeIntervals().merge(intervals);
    System.out.println(result);
  }
}
