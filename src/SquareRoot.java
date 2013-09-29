/**
 * http://leetcode.com/onlinejudge#question_69
 */
public class SquareRoot {
	public static int sqrt(int x) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (x <= 1) {
			return x;
		}
		int left = 0;
		int right = x;
		int mid = left + (right - left) / 2;
		while (right > left) {
			mid = left + (right - left) / 2;
			int result = x / mid;
			if (mid < result) {
				left = mid;
			} else if (mid > result) {
				right = mid;
			} else {
				return mid;
			}
		}
		return left;
	}
}
