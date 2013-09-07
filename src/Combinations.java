import java.util.ArrayList;

/**
 * http://leetcode.com/onlinejudge#question_77
 * 
 * 
 */
public class Combinations {

	ArrayList<ArrayList<Integer>> result;

	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		// Start typing your Java solution below
		// DO NOT write main() function
		result = new ArrayList<ArrayList<Integer>>();
		combine(null, 1, n, k);
		return result;
	}

	private void combine(ArrayList<Integer> partial, int start, int end, int k) {
		if (k == 0) {
			result.add(partial);
			return;
		} else if (start > end || end - start + 1 < k) {
			return;
		} else {
			if (partial == null) {
				partial = new ArrayList<Integer>();
			}
			ArrayList<Integer> withStart = (ArrayList<Integer>) partial.clone();
			withStart.add(start);
			combine(withStart, start + 1, end, k - 1);
			ArrayList<Integer> withoutStart = (ArrayList<Integer>) partial.clone();
			combine(withoutStart, start + 1, end, k);
		}
	}
}
