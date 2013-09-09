public class RemoveValue {
	/**
	 * http://leetcode.com/onlinejudge#question_27
	 */
	public int removeElement(int[] A, int elem) {
		int length = 0;
		int i = 0, j = 0;
		while (A != null && j != A.length) {
			if (A[j] != elem) {
				A[i++] = A[j++];
				length++;
			} else {
				j++;
			}
		}
		return length;
	}
}
