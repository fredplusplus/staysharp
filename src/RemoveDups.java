import java.util.HashMap;
import java.util.Map;

public class RemoveDups {
	/**
	 * http://leetcode.com/oldoj#question_83
	 */
	public ListNode deleteDuplicates1(ListNode head) {
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

	/**
	 * http://leetcode.com/oldoj#question_82
	 */
	public ListNode deleteDuplicates(ListNode head) {
		ListNode meta = new ListNode(0);
		meta.next = head;
		Map<ListNode, Boolean> dupeMap = new HashMap<ListNode, Boolean>();
		while (head != null) {
			if (head.next != null && head.next.val == head.val) {
				head.next = head.next.next;
				dupeMap.put(head, true);
			} else {
				head = head.next;
			}
		}
		head = meta;
		while (head.next != null) {
			if (Boolean.TRUE.equals(dupeMap.get(head.next))) {
				head.next = head.next.next;
			} else {
				head = head.next;
			}
		}
		return meta.next;
	}

	public static void main(String[] args) {
		RemoveDups rd = new RemoveDups();

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
		ListNode newHead = rd.deleteDuplicates(head);
		System.out.println(newHead);
	}

}
