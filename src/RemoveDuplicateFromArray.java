public class RemoveDuplicateFromArray {
	/**
	 * http://leetcode.com/onlinejudge#question_26
	 * 
	 * 
	 */
	public int removeDuplicates(int[] A) {
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
}
