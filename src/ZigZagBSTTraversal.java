import java.util.ArrayList;
import java.util.LinkedList;

public class ZigZagBSTTraversal {
	/**
	 * http://leetcode.com/onlinejudge#question_103
	 */
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root != null) {
			LinkedList<TreeNode> list = new LinkedList<TreeNode>();
			list.addLast(root);
			list.addLast(null);
			boolean reverse = false;
			boolean firstOfRow = true;
			LinkedList<TreeNode> temp = new LinkedList<TreeNode>();
			while (!list.isEmpty()) {
				TreeNode node = list.pop();
				if (node == null) {
					reverse = !reverse;
					if (temp.size() > 0) {
						result.add(new ArrayList<Integer>());
						while (temp.size() > 0) {
							result.get(result.size() - 1).add(temp.removeLast().val);
						}
					}
					if (list.size() != 0) {
						list.add(null);
						firstOfRow = true;
					}
				} else {
					if (reverse) {
						temp.add(node);
					} else {
						if (firstOfRow) {
							result.add(new ArrayList<Integer>());
							firstOfRow = false;
						}
						result.get(result.size() - 1).add(node.val);
					}
					if (node.left != null) {
						list.add(node.left);
					}
					if (node.right != null) {
						list.add(node.right);
					}
				}
			}
		}
		return result;
	}
}
