public class ReverseList {
	/**
	 * http://leetcode.com/oldoj#question_92
	 */
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode meta = new ListNode(0);
		meta.next = head;
		ListNode preM = meta;
		ListNode pre = meta;
		for (int i = 1; i <= n; ++i) {
			if (i == m) {
				preM = pre;
			}
			if (i > m && i <= n) {
				pre.next = head.next;
				head.next = preM.next;
				preM.next = head;
				head = pre;
			}
			pre = head;
			head = head.next;
		}
		return meta.next;
	}

}
