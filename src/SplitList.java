public class SplitList {
	/**
	 * http://leetcode.com/2010/09/splitting-linked-list.html
	 * 
	 */
	public ListNode split(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode second = null;
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			fast = fast.next;
			if (fast.next != null) {
				slow = slow.next;
			}
			fast = fast.next;
		}
		second = slow.next;
		slow.next = null;
		return second;
	}
}
