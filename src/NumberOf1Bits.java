public class NumberOf1Bits {
	/**
	 * http://leetcode.com/2010/09/number-of-1-bits.html
	 */
	public int solve(int value) {
		int bits = 0;
		while (value != 0) {
			if (value != 0) {
				bits++;
			}
			value = value & value - 1;
		}
		return bits;
	}

}
