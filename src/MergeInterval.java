import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeInterval {
	/**
	 * http://leetcode.com/onlinejudge#question_56
	 */
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		Collections.sort(intervals, new Comp());
		ArrayList<Interval> result = new ArrayList<Interval>();
		for (Interval i : intervals) {
			if (result.size() == 0 || result.get(result.size() - 1).end < i.start) {
				result.add(i);
			} else {
				Interval newInterval = i;
				if (result.get(result.size() - 1).end >= newInterval.start) {
					Interval last = result.remove(result.size() - 1);
					newInterval = new Interval(last.start, Math.max(last.end, i.end));
					result.add(newInterval);
				}
			}
		}
		return result;
	}

	private class Comp implements Comparator<Interval> {

		@Override
		public int compare(Interval o1, Interval o2) {
			if (o1.start > o2.start) {
				return 1;
			} else if (o1.start == o2.start) {
				return 0;
			} else {
				return -1;
			}
		}
	}
}
