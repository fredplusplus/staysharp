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

	public static void main(String[] args) {
		InorderBinaryTree inorder = new InorderBinaryTree();

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);

		System.out.println(inorder.inorderTraversal(root));
	}
}
