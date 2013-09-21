import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedList {
	/**
	 * http://leetcode.com/oldoj#question_23
	 */
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		PriorityQueue<ComparableNode> heap = new PriorityQueue<ComparableNode>();
		ListNode meta = new ListNode(0);
		for (ListNode list : lists) {
			if (list != null) {
				heap.add(new ComparableNode(list.val, list.next));
			}
		}
		ListNode tail = meta;
		while (!heap.isEmpty()) {
			ComparableNode node = heap.poll();
			ListNode listNode = new ListNode(node.val);
			tail.next = listNode;
			tail = tail.next;
			if (node.next != null) {
				node = new ComparableNode(node.next.val, node.next.next);
				heap.add(node);
			}
		}
		return meta.next;
	}

	class ComparableNode extends ListNode implements Comparable<ListNode> {

		public ListNode next;

		ComparableNode(int x, ListNode next) {
			super(x);
			this.next = next;
		}

		@Override
		public int compareTo(ListNode o) {
			if (this.val == o.val) {
				return 0;
			} else if (this.val > o.val) {
				return 1;
			} else {
				return -1;
			}
		}
	}
}
