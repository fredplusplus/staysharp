import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class CombinationSum2 {
	private HashSet<ArrayList<Integer>> result;

	/**
	 * http://leetcode.com/oldoj#question_40
	 */
	public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
		result = new HashSet<ArrayList<Integer>>();
		LinkedList<Integer> combo = new LinkedList<Integer>();
		Arrays.sort(candidates);
		solve(candidates, target, 0, combo, 0);
		ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
		for (ArrayList<Integer> res : result) {
			resultList.add(res);
		}
		return resultList;
	}

	public void solve(int[] candidates, int target, int sum, LinkedList<Integer> combo, int n) {
		if (sum == target) {
			ArrayList<Integer> res = new ArrayList<Integer>();
			res.addAll(combo);
			result.add(res);
		} else if (sum > target || n >= candidates.length) {
			return;
		} else {
			combo.addLast(candidates[n]);
			solve(candidates, target, sum + candidates[n], combo, n + 1);
			combo.removeLast();
			solve(candidates, target, sum, combo, n + 1);
		}
	}

	public static void main(String[] args) {
		CombinationSum2 cs = new CombinationSum2();
		ArrayList<ArrayList<Integer>> res = cs.combinationSum2(new int[] { 2, 3, 3 }, 6);
		System.out.println(res);
	}
}
