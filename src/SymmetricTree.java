/**
 * http://leetcode.com/onlinejudge#question_101
 * 
 * @author fanzhang
 * 
 */
public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isSymmetricToEachOther(root.left, root.right);
	}

	private boolean isSymmetricToEachOther(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		} else if (left != null && right != null) {
			return left.val == right.val && isSymmetricToEachOther(left.left, right.right)
					&& isSymmetricToEachOther(left.right, right.left);
		} else {
			return false;
		}
	}

}
