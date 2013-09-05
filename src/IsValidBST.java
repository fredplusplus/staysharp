/**
 * http://leetcode.com/onlinejudge#question_98
 * 
 */
public class IsValidBST {
	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isValidBST(TreeNode root, int min, int max) {
		if (root == null) {
			return true;
		}
		if (root.val > max || root.val < min) {
			return false;
		}
		boolean left = true;
		boolean right = true;
		if (root.left != null) {
			left = isValidBST(root.left, min, root.val - 1);
		}
		if (root.right != null) {
			right = isValidBST(root.right, root.val + 1, max);
		}
		return left && right;
	}
}
