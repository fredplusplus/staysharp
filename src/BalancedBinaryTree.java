/**
 * http://leetcode.com/onlinejudge#question_110
 * 
 * @author fanzhang
 * 
 */
public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		return height(root) >= 0;
	}

	private int height(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		if (leftHeight < 0 || rightHeight < 0) {
			return -1;
		}
		if (Math.abs(leftHeight - rightHeight) <= 1) {
			return 1 + Math.max(leftHeight, rightHeight);
		} else {
			return -1;
		}
	}
}
