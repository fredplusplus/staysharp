import java.util.ArrayList;
import java.util.LinkedList;

/**
 * http://leetcode.com/onlinejudge#question_102
 * 
 * @author fanzhang
 * 
 */
public class LevelOrderTraverseBinaryTree {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		if (root != null) {
			results.add(new ArrayList<Integer>());
			LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
			queue.addLast(root);
			queue.addLast(null);
			while (!queue.isEmpty()) {
				TreeNode node = queue.removeFirst();
				if (node != null) {
					results.get(results.size() - 1).add(node.val);
					if (node.left != null) {
						queue.addLast(node.left);
					}
					if (node.right != null) {
						queue.addLast(node.right);
					}
				} else {
					if (queue.isEmpty()) {
						break;
					} else {
						results.add(new ArrayList<Integer>());
						queue.addLast(null);
					}
				}
			}
		}
		return results;
	}

	public static void main(String[] args) {
		LevelOrderTraverseBinaryTree l = new LevelOrderTraverseBinaryTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		l.levelOrder(root);
	}
}
