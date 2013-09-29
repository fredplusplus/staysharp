/**
 * http://leetcode.com/onlinejudge#question_50
 * 
 * @author fanzhang
 * 
 */
public class Pow {

	public double pow(double x, int n) {
		if (x == 1) {
			return 1;
		} else if (x == -1) {
			if (n % 2 == 0) {
				return 1;
			} else {
				return -1;
			}
		} else if (n == 0) {
			return 1;
		} else if (n > 0) {
			return multiplyPow(x, n);
		} else {
			return 1 / multiplyPow(x, -n);
		}
	}

	private double multiplyPow(double x, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n == 1) {
			return x;
		}
		int half = n / 2;
		double halfPow = multiplyPow(x, half);
		double result = halfPow * halfPow;
		if (half * 2 == n - 1) {
			result = result * x;
		}
		return result;
	}
}
