/**
 * http://leetcode.com/onlinejudge#question_86
 * 
 */
public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		if (head == null) {
			return null;
		}
		// add head to list just for easy manipulation
		ListNode small = new ListNode(0);
		ListNode smallTail = small;
		ListNode large = new ListNode(0);
		ListNode largeTail = large;
		ListNode list = new ListNode(0);
		list.next = head;

		while (list.next != null) {
			// remove node
			ListNode node = list.next;
			list.next = node.next;
			if (node != null) {
				node.next = null;
				// insert to small/large list
				if (node.val < x) {
					smallTail.next = node;
					smallTail = node;
				} else {
					largeTail.next = node;
					largeTail = node;
				}
			}
		}
		// return headless list because apparently OG likes headless.
		if (small.next == null) {
			return large.next;
		} else if (large.next == null) {
			return small.next;
		} else {
			smallTail.next = large.next;
			return small.next;
		}
	}
}
