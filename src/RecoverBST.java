import java.util.ArrayList;

public class RecoverBST {

	private ArrayList<TreeNode> list;
	private TreeNode prev;

	/**
	 * http://leetcode.com/oldoj#question_99
	 */
	public void recoverTree(TreeNode root) {
		list = new ArrayList<TreeNode>();
		prev = null;
		inorder(root);
		if (!list.isEmpty()) {
			int temp = list.get(0).val;
			list.get(0).val = list.get(list.size() - 1).val;
			list.get(list.size() - 1).val = temp;
		}
	}

	private void inorder(TreeNode root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		if (prev != null && prev.val > root.val) {
			list.add(prev);
			list.add(root);
		}
		prev = root;
		inorder(root.right);
	}
}
