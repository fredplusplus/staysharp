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

	/**
	 * http://leetcode.com/onlinejudge#question_107
	 */
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		traverseBottom(result, root, 0);
		return result;
	}

	private void traverseBottom(ArrayList<ArrayList<Integer>> result, TreeNode root, int level) {
		if (root == null) {
			return;
		} else {
			int size = result.size();
			if (level == size) {
				result.add(0, new ArrayList<Integer>());
				result.get(0).add(root.val);
			} else {
				result.get(size - level - 1).add(root.val);
			}
			traverseBottom(result, root.left, level + 1);
			traverseBottom(result, root.right, level + 1);
		}
	}
}
