public class SwapListNodePair {
	/**
	 * http://leetcode.com/onlinejudge#question_24
	 */
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		} else {
			ListNode next = head.next;
			head.next = next.next;
			next.next = head;
			head = next;
			head.next.next = swapPairs(head.next.next);
			return head;
		}
	}
}
