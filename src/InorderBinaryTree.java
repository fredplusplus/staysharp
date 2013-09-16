import java.util.ArrayList;
import java.util.Stack;

public class InorderBinaryTree {
	/**
	 * http://leetcode.com/onlinejudge#question_94
	 */
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root != null) {
			Stack<TreeNode> stack = new Stack<TreeNode>();
			stack.push(root);
			TreeNode left = root.left;
			while (left != null) {
				stack.push(left);
				left = left.left;
			}

			while (!stack.isEmpty()) {
				TreeNode node = stack.pop();
				result.add(node.val);
				if (node.right != null) {
					stack.push(node.right);
					left = node.right.left;
					while (left != null) {
						stack.push(left);
						left = left.left;
					}
				}
			}
		}
		return result;
	}
}
