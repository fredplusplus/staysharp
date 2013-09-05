/**
 * http://leetcode.com/onlinejudge#question_111
 * 
 * @author fanzhang
 * 
 */
public class MinMaxTreeDepth {
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		} else if (root.left == null && root.right == null) {
			return 1;
		}
		int leftDepth = minDepth(root.left);
		int rightDepth = minDepth(root.right);
		if (leftDepth != 0 && rightDepth != 0) {
			return 1 + Math.min(leftDepth, rightDepth);
		} else if (leftDepth == 0) {
			return 1 + rightDepth;
		} else {
			return 1 + leftDepth;
		}
	}
}
