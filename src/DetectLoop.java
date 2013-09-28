public class DetectLoop {
	/**
	 * http://leetcode.com/2010/09/detecting-loop-in-singly-linked-list.html
	 */
	public boolean isLoop(ListNode head) {
		boolean loop = false;
		if (head != null) {
			ListNode fast = head;
			ListNode slow = head;
			while (fast != null && fast.next != null) {
				fast = fast.next.next;
				slow = slow.next;
				if (slow == fast) {
					loop = true;
					break;
				}
			}
		}
		return loop;
	}
}
