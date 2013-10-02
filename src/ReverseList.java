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

	/**
	 * http://oj.leetcode.com/problems/reverse-nodes-in-k-group/
	 * 
	 */
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newhead = null;
		ListNode tail = null;
		int count = 0;
		while (head != null && count < k) {
			ListNode next = head.next;
			head.next = newhead;
			newhead = head;
			if (count == 0) {
				tail = newhead;
			}
			head = next;
			count++;
		}
		if (count < k) {
			while(newhead != null) {
				ListNode next = newhead.next;
				newhead.next = head;
				head = newhead;
				newhead = next;
			}
			return head;
		} else {
			tail.next = reverseKGroup(head, k);
			return newhead;
		}
	}

	private void printList(ListNode head) {
		while (head != null) {
			System.out.println(head.val + "   ");
			head = head.next;

		}
	}

	public static void main(String[] args) {
		ReverseList rl = new ReverseList();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		rl.printList(rl.reverseKGroup(head, 3));
	}

}
