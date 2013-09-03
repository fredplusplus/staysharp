/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given sum.
 * 
 * 
 */
public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		if (root.left == null && root.right == null && root.val == sum) {
			return true;
		} else {
			int partialSum = sum - root.val;
			return hasPathSum(root.left, partialSum) || hasPathSum(root.right, partialSum);
		}
	}
}
