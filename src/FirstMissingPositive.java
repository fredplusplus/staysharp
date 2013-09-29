public class FirstMissingPositive {
	/**
	 * http://leetcode.com/oldoj#question_41
	 */
	public int firstMissingPositive(int[] A) {
		int i = 0;
		for (i = 0; i < A.length; i++) {
			if (A[i] >= 1 && A[i] <= A.length && A[i] != i + 1 && A[i] != A[A[i] - 1]) {
				int temp = A[i];
				A[i] = A[temp - 1];
				A[temp - 1] = temp;
				i--;
			}
		}

		for (i = 0; i < A.length; i++) {
			if (A[i] != i + 1) {
				return i + 1;
			}
		}
		return i + 1;
	}
}
