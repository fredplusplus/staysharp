import java.util.ArrayList;
import java.util.Arrays;

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

	private void subsets(ArrayList<ArrayList<Integer>> partial, int[] S, int index) {
		if (index == S.length) {
			return;
		}
		ArrayList<ArrayList<Integer>> newPartial = new ArrayList<ArrayList<Integer>>();
		for (ArrayList<Integer> set : partial) {
			ArrayList<Integer> newSet = (ArrayList<Integer>) set.clone();
			newSet.add(0, S[index]);
			newPartial.add(newSet);
		}
		subsets(newPartial, S, index + 1);
		subsets(partial, S, index + 1);
		partial.addAll(newPartial);
	}

	public static void main(String[] args) {
		SubSet ss = new SubSet();
		ArrayList<ArrayList<Integer>> set = ss.subsets(new int[] { 1, 4, 0 });
		System.out.println(set.size());
	}
}
