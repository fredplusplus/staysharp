import java.util.Arrays;

public class MaxDistance {

	class Node implements Comparable<Node> {
		int val;
		int index;
		int end;

		Node(int v, int idx) {
			val = v;
			index = idx;
		}

		@Override
		public int compareTo(Node o) {
			if (this.val == o.val) {
				return 0;
			} else if (this.val > o.val) {
				return 1;
			} else {
				return -1;
			}
		}

	}

	int findMaxDistance(int[] A) {
		Node[] array = new Node[A.length];
		for (int i = 0; i < A.length; i++) {
			array[i] = new Node(A[i], i);
		}
		Arrays.sort(array);
		for (int i = array.length - 1; i >= 0; i--) {
			if (i == array.length - 1) {
				array[i].end = array[i].index;
			} else {
				array[i].end = Math.max(array[i + 1].end, array[i + 1].index);
			}
		}
		int i = 0;
		int maxLength = 0;
		while (i < array.length) {
			while (i < array.length - 1 && array[i] == array[i + 1]) {
				i++;
			}
			maxLength = Math.max(maxLength, array[i].end - array[i].index);
			i++;
		}
		return maxLength;
	}
}
