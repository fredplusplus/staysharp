import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubSet {
	/**
	 * http://leetcode.com/onlinejudge#question_78
	 */
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		ArrayList<ArrayList<Integer>> set = new ArrayList<ArrayList<Integer>>();
		set.add(new ArrayList<Integer>());
		if (S != null) {
			Arrays.sort(S);
		}
		subsets(set, S, 0);
		return set;
	}

	/**
	 * http://leetcode.com/onlinejudge#question_90
	 */
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> set = new ArrayList<ArrayList<Integer>>();
		set.add(new ArrayList<Integer>());
		if (num != null) {
			Arrays.sort(num);
		}
		subsets(set, num, 0);
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for (ArrayList<Integer> s : set) {
			if (!map.containsKey(s.toString())) {
				map.put(s.toString(), true);
				result.add(s);
			}
		}
		return result;
	}

	private void subsets(ArrayList<ArrayList<Integer>> partial, int[] S, int index) {
		if (index == S.length) {
			return;
		}
		ArrayList<ArrayList<Integer>> newPartial = new ArrayList<ArrayList<Integer>>();
		for (ArrayList<Integer> set : partial) {
			ArrayList<Integer> newSet = (ArrayList<Integer>) set.clone();
			newSet.add(S[index]);
			newPartial.add(newSet);
		}
		subsets(newPartial, S, index + 1);
		subsets(partial, S, index + 1);
		partial.addAll(newPartial);
	}
}
