/**
 * http://leetcode.com/onlinejudge#question_2
 * 
 * @author fanzhang
 * 
 */
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int carry = 0;
		ListNode rootListNode = new ListNode(-1);
		ListNode currentListNode = rootListNode;
		while (l1 != null || l2 != null) {
			int sum = carry;
			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}
			if (sum >= 10) {
				carry = 1;
				sum -= 10;
			} else {
				carry = 0;
			}
			ListNode n = new ListNode(sum);
			currentListNode.next = n;
			currentListNode = currentListNode.next;
		}
		if (carry != 0) {
			currentListNode.next = new ListNode(carry);
		}
		return rootListNode.next;
	}
}
