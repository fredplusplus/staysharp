public class PopulateNextRight {
	/**
	 * http://leetcode.com/oldoj#question_116
	 */
	public void connect(TreeLinkNode root) {
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
}
