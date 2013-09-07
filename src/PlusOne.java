/**
 * http://leetcode.com/onlinejudge#question_66
 * 
 * @author fanzhang
 * 
 */
public class PlusOne {
	public int[] plusOne(int[] digits) {
		if (digits == null || digits.length == 0) {
			return digits;
		}
		int carry = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			digits[i] = digits[i] + carry;
			if (digits[i] == 10) {
				digits[i] = 0;
				carry = 1;
			} else {
				carry = 0;
			}
		}
		int[] result;
		int resultIdx = 0;
		int digitsIdx = 0;
		if (carry == 1) {
			result = new int[1 + digits.length];
			result[0] = carry;
			resultIdx = 1;
		} else {
			result = new int[digits.length];
		}
		while (resultIdx < result.length) {
			result[resultIdx++] = digits[digitsIdx++];
		}
		return result;
	}
}
