/**
 * http://leetcode.com/onlinejudge#question_8
 * 
 */
public class AtoI {
	public int atoi(String str) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (str == null) {
			return 0;
		} else {
			str = str.trim();
			boolean valid = true;
			boolean outOfRange = false;
			int prev = 0;
			int sign = 1;
			int value = 0;
			if (str.length() == 0) {
				return 0;
			}

			for (int i = 0; i < str.length(); i++) {
				if (i == 0) {
					if (str.charAt(i) == '-') {
						sign = -1;
					} else if (str.charAt(i) == '+') {
						sign = 1;
					} else {
						if (isDigit(str.charAt(i))) {
							value = prev * 10 + convertDigit(str.charAt(i));
							prev = value;
						} else {
							break;
						}
					}
				} else {
					if (isDigit(str.charAt(i))) {
						value = prev * 10 + convertDigit(str.charAt(i));
						if (value / 10 == prev) {
							prev = value;
						} else {
							outOfRange = true;
							break;
						}
					} else {
						break;
					}
				}
			}
			if (outOfRange) {
				if (sign > 0)
					return Integer.MAX_VALUE;
				else
					return Integer.MIN_VALUE;
			} else {
				return sign * value;
			}
		}
	}

	private boolean isDigit(char c) {
		return convertDigit(c) >= 0 && convertDigit(c) <= 9;
	}

	private int convertDigit(char c) {
		return c - '0';
	}
}
