/**
 * http://leetcode.com/onlinejudge#question_109
 * 
 * @author fanzhang
 * 
 */
public class SortedListToBST {
	private ListNode head;

	public TreeNode sortedListToBST(ListNode head) {
		this.head = head;
		// Start typing your Java solution below
		// DO NOT write main() function
		int length = 0;
		ListNode current = head;
		while (current != null) {
			length++;
			current = current.next;
		}
		if (length == 0) {
			return null;
		}
		return buildBST(0, length - 1);
	}

	private TreeNode buildBST(int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = start + (end - start) / 2;
		TreeNode left = buildBST(start, mid - 1);
		TreeNode root = new TreeNode(head.val);
		head = head.next;
		TreeNode right = buildBST(mid + 1, end);
		root.left = left;
		root.right = right;
		return root;
	}
}
