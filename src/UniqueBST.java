import java.util.ArrayList;

public class UniqueBST {
	/**
	 * http://leetcode.com/oldoj#question_95
	 */
	public ArrayList<TreeNode> generateTrees(int n) {
		return generate(1, n);
	}

	private ArrayList<TreeNode> generate(int start, int end) {
		ArrayList<TreeNode> result = new ArrayList<TreeNode>();
		if (start <= end) {
			for (int i = start; i <= end; i++) {
				ArrayList<TreeNode> leftSet = generate(start, i - 1);
				ArrayList<TreeNode> rightSet = generate(i + 1, end);
				for (TreeNode left : leftSet) {
					for (TreeNode right : rightSet) {
						TreeNode root = new TreeNode(i);
						root.left = left;
						root.right = right;
						result.add(root);
					}
				}
			}
		} else {
			result.add(null);
		}
		return result;
	}

	public static void main(String[] args) {
		UniqueBST ub = new UniqueBST();
		ub.generateTrees(2);
		System.out.println(ub);
	}
}
