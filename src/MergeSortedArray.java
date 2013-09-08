public class MergeSortedArray {
	/**
	 * http://leetcode.com/onlinejudge#question_88
	 * 
	 */
	public void merge(int A[], int m, int B[], int n) {
		int pa = m - 1;
		int pb = n - 1;
		int pc = m + n - 1;
		while (pa >= 0 && pb >= 0) {
			if (A[pa] > B[pb]) {
				A[pc--] = A[pa--];
			} else {
				A[pc--] = B[pb--];
			}
		}
		while (pa >= 0) {
			A[pc--] = A[pa--];
		}
		while (pb >= 0) {
			A[pc--] = B[pb--];
		}
	}

	/**
	 * http://leetcode.com/onlinejudge#question_21
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		} else {
			ListNode l = null;
			ListNode tail = l;
			while (l1 != null && l2 != null) {
				ListNode node;
				if (l1.val < l2.val) {
					node = l1;
					l1 = l1.next;

				} else {
					node = l2;
					l2 = l2.next;
				}
				node.next = null;
				if (l == null) {
					l = node;
					tail = node;
				} else {
					tail.next = node;
					tail = node;
				}
			}
			if (l1 != null) {
				tail.next = l1;
			} else {
				tail.next = l2;
			}
			return l;
		}
	}
}
