/**
 * http://leetcode.com/onlinejudge#question_70
 * 
 * @author fanzhang
 * 
 */
public class ClimbStairs {
	public int climbStairs(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n == 1) {
			return 1;
		} else if (n == 2) {
			return 2;
		} else {
			int pre1 = 1;
			int pre2 = 2;
			int result;
			int count = 3;
			do {
				result = pre1 + pre2;
				pre1 = pre2;
				pre2 = result;
				count++;
			} while (count <= n);
			return result;
		}
	}
}
