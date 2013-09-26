import java.util.ArrayList;
import java.util.List;

public class IntersectionOfSortedArray {
	/**
	 * http://leetcode.com/2010/03/here-is-phone-screening-question-from.html
	 */
	public List<Integer> intersection(List<Integer> array1, List<Integer> array2) {
		List<Integer> result = new ArrayList<Integer>();
		if (array1 != null && array2 != null) {
			int i = 0;
			int j = 0;
			while (i < array1.size() && j < array2.size()) {
				if (array1.get(i) == array2.get(j)) {
					result.add(array1.get(i));
					i++;
					j++;
				} else if (array1.get(i) < array2.get(j)) {
					i++;
				} else {
					j++;
				}
			}
		}
		return result;
	}
}
