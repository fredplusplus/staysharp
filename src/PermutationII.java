import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class PermutationII {
	/**
	 * http://leetcode.com/oldoj#question_47
	 */
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		ArrayList<ArrayList<Integer>> set = new ArrayList<ArrayList<Integer>>();
		boolean[] used = new boolean[num.length];
		Arrays.sort(num);
		LinkedList<Integer> path = new LinkedList<Integer>();
		permute(num, used, path, set);
		return set;
	}

	private void permute(int[] num, boolean[] used, LinkedList<Integer> path, ArrayList<ArrayList<Integer>> set) {
		if (path.size() == num.length) {
			ArrayList<Integer> res = new ArrayList<Integer>();
			res.addAll(path);
			set.add(res);
		} else {
			for (int i = 0; i < num.length; i++) {
				if (used[i] || (i != 0 && num[i] == num[i - 1] && used[i - 1])) {
					continue;
				} else {
					used[i] = true;
					path.addLast(num[i]);
					permute(num, used, path, set);
					used[i] = false;
					path.removeLast();
				}
			}
		}
	}
}
