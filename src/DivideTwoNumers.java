public class DivideTwoNumers {
	/**
	 * http://leetcode.com/onlinejudge#question_29
	 */
	public int divide(int dividend, int divisor) {
		long a = Math.abs((long) dividend);
		long b = Math.abs((long) divisor);
		boolean up = true;
		int i = 0;
		int ret = 0;
		while (a >= b) {
			long c = b << i;
			if (a - c >= 0) {
				a -= c;
				ret += 1 << i;
			}
			if (up) {
				i++;
				if (a < c << 1) {
					up = false;
				}
			} else {
				i--;
			}
		}
		return (dividend ^ divisor) >> 31 != 0 ? -ret : ret;
	}
}
