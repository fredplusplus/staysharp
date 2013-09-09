/**
 * http://leetcode.com/onlinejudge#question_7
 * 
 */
public class ReverseInteger {
	public int reverse(int x) {
		int isPositive = 1;
		if (x < 0) {
			isPositive = -1;
			x = -x;
		}
		int reverse = 0;
		while (x != 0) {
			reverse = reverse * 10 + x % 10;
			x = x / 10;
		}
		return isPositive * reverse;
	}
}
