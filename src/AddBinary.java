public class AddBinary {
	/**
	 * http://leetcode.com/onlinejudge#question_67
	 */
	public String addBinary(String a, String b) {
		if (a == null || a.isEmpty()) {
			return b;
		} else if (b == null || b.isEmpty()) {
			return a;
		}
		String result = "";
		int i = a.length() - 1;
		int j = b.length() - 1;
		int carry = 0;
		while (i >= 0 && j >= 0) {
			int resultBit = (a.charAt(i--) - '0') + (b.charAt(j--) - '0') + carry;
			if (resultBit >= 2) {
				carry = 1;
				resultBit = (resultBit - 1) / 2;
			} else {
				carry = 0;
			}
			result = resultBit + result;
		}
		while (i >= 0) {
			int resultBit = (a.charAt(i--) - '0') + carry;
			if (resultBit >= 2) {
				carry = 1;
				resultBit = (resultBit - 1) / 2;
			} else {
				carry = 0;
			}
			result = resultBit + result;
		}
		while (j >= 0) {
			int resultBit = (b.charAt(j--) - '0') + carry;
			if (resultBit >= 2) {
				carry = 1;
				resultBit = (resultBit - 1) / 2;
			} else {
				carry = 0;
			}
			result = resultBit + result;
		}
		if (carry == 1) {
			result = "1" + result;
		}
		return result;
	}

}
