import java.util.ArrayList;

/**
 * http://leetcode.com/onlinejudge#question_113
 */
public class PathSumTwo {

	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return results;
		} else if (root.val == sum && root.left == null && root.right == null) {
			ArrayList<Integer> result = new ArrayList<Integer>();
			result.add(root.val);
			results.add(result);
			return results;
		} else {
			int partialSum = sum - root.val;
			ArrayList<ArrayList<Integer>> leftResult = pathSum(root.left, partialSum);
			if (!leftResult.isEmpty()) {
				for (ArrayList<Integer> result : leftResult) {
					result.add(0, root.val);
				}
				results.addAll(leftResult);
			}
			ArrayList<ArrayList<Integer>> rightResult = pathSum(root.right, partialSum);
			if (!rightResult.isEmpty()) {
				for (ArrayList<Integer> result : rightResult) {
					result.add(0, root.val);
				}
				results.addAll(rightResult);
			}
			return results;
		}
	}
}
