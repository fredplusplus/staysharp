public class JumpGame {
	/**
	 * http://leetcode.com/onlinejudge#question_55
	 * 
	 */
	public boolean canJump(int[] A) {
		int canReachEnd = A.length - 1;
		for (int i = A.length - 2; i >= 0; i--) {
			if (A[i] + i >= canReachEnd) {
				canReachEnd = i;
			}
		}
		return canReachEnd == 0;
	}

	/**
	 * http://leetcode.com/onlinejudge#question_45
	 */
	public int jump(int A[]) {
		int ret = 0;
		int last = 0;
		int curr = 0;
		for (int i = 0; i < A.length; ++i) {
			if (i > last) {
				last = curr;
				++ret;
			}
			curr = Math.max(curr, i + A[i]);
		}

		return ret;
	}
}
