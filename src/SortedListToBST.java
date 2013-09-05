/**
 * http://leetcode.com/onlinejudge#question_109
 * 
 * @author fanzhang
 * 
 */
public class SortedListToBST {
	public TreeNode sortedListToBST(ListNode head) {
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
		return buildBST(head, 0, length - 1);
	}

	private TreeNode buildBST(ListNode head, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = start + (end - start) / 2;
		TreeNode left = buildBST(head, start, mid - 1);
		TreeNode root = new TreeNode(head.val);
		head = head.next;
		TreeNode right = buildBST(head, mid + 1, end);
		root.left = left;
		root.right = right;
		return root;
	}
}
