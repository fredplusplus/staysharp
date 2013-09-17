public class RemoveDuplicateFromArray {
	/**
	 * http://leetcode.com/onlinejudge#question_26
	 * 
	 * 
	 */
	public int removeDuplicates1(int[] A) {
		if (A == null) {
			return 0;
		} else {
			int count = 0;
			int i = 0, j = 0;
			int prev = 0;
			for (i = 0; i < A.length; i++) {
				if (i == 0 || A[i] != prev) {
					A[j++] = A[i];
					count++;
				}
				prev = A[i];
			}

			return count;
		}
	}

	/**
	 * http://leetcode.com/oldoj#question_80
	 */
	public int removeDuplicates(int[] A) {
		if (A.length < 3) {
			return A.length;
		}

		int i = 1;
		int j = 1;
		int count = 1;
		for (j = 1; j < A.length; j++) {
			if (A[j - 1] == A[j]) {
				count++;
			} else {
				count = 1;
			}
			if (count <= 2) {
				A[i++] = A[j];
			}
		}
		return i;
	}
}
