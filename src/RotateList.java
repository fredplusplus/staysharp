/**
 * http://leetcode.com/onlinejudge#question_61
 * 
 */
public class RotateList {
	public ListNode rotateRight(ListNode head, int n) {
		if (n <= 0 || head == null) {
			return head;
		}
		ListNode probe = head;
		int size = 0;
		while (probe != null) {
			probe = probe.next;
			size++;
		}
		n = n % size;
		if (n == 0) {
			return head;
		}
		ListNode split = head;
		for (int i = 0; i < n - 1; i++) {
			split = split.next;
		}
		ListNode newHead = split.next;
		while (newHead.next != null) {
			newHead = newHead.next;
		}
		newHead.next = head;
		return newHead;
	}
}
