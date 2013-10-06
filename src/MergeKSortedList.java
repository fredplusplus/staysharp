import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedList {
	/**
	 * http://leetcode.com/oldoj#question_23
	 */
	private class MyNode implements Comparable<MyNode> {
		public ListNode node;

		public MyNode(ListNode node) {
			this.node = node;
		}

		public int compareTo(MyNode other) {
			if (node.val > other.node.val) {
				return 1;
			} else {
				return -1;
			}
		}
	}

	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		PriorityQueue<MyNode> heap = new PriorityQueue<MyNode>();
		for (ListNode node : lists) {
			if (node != null) {
				heap.add(new MyNode(node));
			}
		}
		ListNode head = new ListNode(0);
		ListNode tail = head;
		while (!heap.isEmpty()) {
			MyNode mynode = heap.poll();
			ListNode node = mynode.node;
			if (node.next != null) {
				heap.add(new MyNode(node.next));
				node.next = null;
			}
			tail.next = node;
			tail = tail.next;
		}
		return head.next;
	}
	
	public static void main(String[] args) {
		ArrayList<ListNode> lists = new ArrayList<ListNode>();
		lists.add(new ListNode(1));
		lists.add(new ListNode(0));
		MergeKSortedList me = new MergeKSortedList();
		me.mergeKLists(lists);
	}
}
