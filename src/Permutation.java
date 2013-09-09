import java.util.ArrayList;

public class Permutation {
	/**
	 * http://leetcode.com/onlinejudge#question_46
	 */
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		permute(results, num, 0);
		return results;
	}

	private void permute(ArrayList<ArrayList<Integer>> results, int[] num, int index) {
		if (index == num.length - 1) {
			ArrayList<Integer> res = new ArrayList<Integer>();
			for (int n : num) {
				res.add(n);
			}
			results.add(res);
			return;
		} else {
			for (int i = index; i < num.length; ++i) {
				int temp = num[index];
				num[index] = num[i];
				num[i] = temp;
				permute(results, num, index + 1);
				temp = num[index];
				num[index] = num[i];
				num[i] = temp;
			}
		}
	}
}
