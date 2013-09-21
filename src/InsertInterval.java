import java.util.ArrayList;

public class InsertInterval {
	/**
	 * http://leetcode.com/oldoj#question_57
	 */
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		ArrayList<Interval> result = new ArrayList<Interval>();
		int size = intervals.size();
		int i = 0;
		while (i < size && intervals.get(i).end < newInterval.start) {
			result.add(intervals.get(i));
			i++;
		}
		while (i < size && intervals.get(i).start <= newInterval.end) {
			newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
			newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
			i++;
		}
		result.add(newInterval);
		while (i < size) {
			result.add(intervals.get(i++));
		}
		return result;
	}
}
