public class RemoveDups {
	/**
	 * http://leetcode.com/oldoj#question_83
	 */
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode node = head;
		while (node != null) {
			if (node.next != null && node.val == node.next.val) {
				node.next = node.next.next;

			} else {
				node = node.next;
			}
		}
		return head;
	}
}
