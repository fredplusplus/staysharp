import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {
	private ArrayList<ArrayList<Integer>> result;

	/**
	 * http://leetcode.com/oldoj#question_39
	 */
	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
		result = new ArrayList<ArrayList<Integer>>();
		int[] index = new int[1000];
		Arrays.sort(candidates);
		solve(candidates, target, 0, index, 0);
		return result;
	}

	private void solve(int[] candidates, int target, int sum, int[] index, int n) {
		if (sum > target) {
			return;
		} else if (sum == target) {
			addToResult(candidates, index, n);
		} else {
			for (int i = index[n]; i < candidates.length; i++) {
				index[n + 1] = i;
				solve(candidates, target, sum + candidates[i], index, n + 1);
			}
		}
	}

	private void addToResult(int[] candidates, int[] index, int n) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			res.add(candidates[index[i]]);
		}
		result.add(res);
	}
}
