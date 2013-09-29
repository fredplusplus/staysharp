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

	public ListNode reverseIterative(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		} else {
			ListNode newHead = null;
			while (head != null) {
				ListNode node = head;
				head = head.next;
				node.next = newHead;
				newHead = node;
			}
			return newHead;
		}
	}
	private void printList(ListNode head) {
		while (head != null) {
			System.out.println(head.val + "   ");
			head = head.next;

		}
	}

}
