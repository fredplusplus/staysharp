/**
 * http://leetcode.com/onlinejudge#question_55
 * 
 */
public class JumpGame {
	public boolean canJump(int[] A) {
		int canReachEnd = A.length - 1;
		for (int i = A.length - 2; i >= 0; i--) {
			if (A[i] + i >= canReachEnd) {
				canReachEnd = i;
			}
		}
		return canReachEnd == 0;
	}
}
