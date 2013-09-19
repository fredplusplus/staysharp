public class DecodeWays {
	/**
	 * http://leetcode.com/oldoj#question_91
	 */
	public int numDecodings(String s) {
		char[] str = s.toCharArray();
		return decodeLoopStyle(str);
	}

	private int decodeLoopStyle(char[] str) {
		if (str.length == 0) {
			return 0;
		}
		int[] counts = new int[str.length];
		for (int i = counts.length - 1; i >= 0; i--) {
			if (i == counts.length - 1) {
				counts[i] = canDecode(str, i, i) ? 1 : 0;
			} else if (i == counts.length - 2) {
				counts[i] = (canDecode(str, i, i) ? counts[i + 1] : 0) + (canDecode(str, i, i + 1) ? 1 : 0);
			} else {
				counts[i] = (canDecode(str, i, i) ? counts[i + 1] : 0) + (canDecode(str, i, i + 1) ? counts[i + 2] : 0);
			}
		}
		return counts[0];
	}

	private boolean canDecode(char[] str, int start, int end) {
		int result = 0;
		for (int i = start; i <= end; i++) {
			result = result * 10 + (str[i] - '0');
		}
		return (start == end && result >= 1 && result <= 9) || (start == end - 1 && result >= 10 && result <= 26);
	}
}
