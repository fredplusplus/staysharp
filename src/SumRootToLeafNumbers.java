import java.util.ArrayList;
import java.util.List;

/**
 * http://leetcode.com/onlinejudge#question_129
 * **/
public class SumRootToLeafNumbers {
	List<Integer> numbers;

	public int sumNumbers(TreeNode root) {
		numbers = new ArrayList<Integer>();
		// pre-order everything & construct numbers
		traverse(root, 0);
		// parse numbers and add em up
		int sum = 0;
		for (Integer number : numbers) {
			sum += number;
		}
		return sum;
	}

	private void traverse(TreeNode root, int partial) {
		if (root != null) {
			partial = partial * 10 + root.val;
			if (root.left == null && root.right == null) {
				numbers.add(partial);
			} else {
				if (root.left != null) {
					traverse(root.left, partial);
				}
				if (root.right != null) {
					traverse(root.right, partial);
				}
			}
		}
	}
}
