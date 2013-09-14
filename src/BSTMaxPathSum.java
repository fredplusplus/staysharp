public class BSTMaxPathSum {
	/**
	 * http://leetcode.com/onlinejudge#question_124
	 */
	private int maxSum;

	public int maxPathSum(TreeNode root) {
		maxSum = Integer.MIN_VALUE;
		if (root == null) {
			return maxSum;
		} else {
			maxSubPath(root);
			return maxSum;
		}
	}

	private int maxSubPath(TreeNode root) {
		int sum = 0;
		if (root != null) {
			int leftSum = maxSubPath(root.left);
			int rightSum = maxSubPath(root.right);
			sum = Math.max(0, Math.max(leftSum, rightSum));
			maxSum = Math.max(root.val + leftSum + rightSum, maxSum);
		}
		return Math.max(root == null ? 0 : root.val + sum, 0);
	}
}
