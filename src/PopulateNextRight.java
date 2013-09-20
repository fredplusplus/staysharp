import java.util.LinkedList;

public class PopulateNextRight {
	/**
	 * http://leetcode.com/oldoj#question_116
	 */
	public void connect1(TreeLinkNode root) {
		TreeLinkNode leftFront = root;
		while (leftFront != null) {
			TreeLinkNode across = leftFront;
			while (across != null) {
				if (across.left != null) {
					across.left.next = across.right;
				}
				if (across.right != null && across.next != null) {
					across.right.next = across.next.left;
				}
				across = across.next;
			}
			leftFront = leftFront.left;
		}
	}

	/**
	 * http://leetcode.com/oldoj#question_117
	 */
	public void connect(TreeLinkNode root) {
		LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		if (root != null) {
			queue.add(root);
			queue.addLast(null);
			TreeLinkNode prev = null;
			while (!queue.isEmpty()) {
				TreeLinkNode current = queue.removeFirst();
				if (prev != null && current != null) {
					prev.next = current;
				}
				prev = current;
				if (current == null) {
					if (queue.isEmpty()) {
						break;
					} else {
						queue.addLast(null);
					}
				} else {
					if (current.left != null) {
						queue.addLast(current.left);
					}
					if (current.right != null) {
						queue.addLast(current.right);
					}
				}
			}
		}
	}
}
