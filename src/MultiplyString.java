public class MultiplyString {
	/**
	 * http://leetcode.com/oldoj#question_43
	 */
	public String multiply(String num1, String num2) {
		String result = "0";
		for (int i = num2.length() - 1; i >= 0; i--) {
			String partialMultiply = multplyDigit(num1, num2.charAt(i) - '0', num2.length() - i - 1);
			result = add(result, partialMultiply);
		}
		return result;
	}

	private String multplyDigit(String num1, int digit, int offset) {
		int carry = 0;
		String result = "";
		if (digit == 0) {
			return "0";
		} else {
			for (int i = num1.length() - 1; i >= 0; i--) {
				int m = (num1.charAt(i) - '0') * digit + carry;
				result = m % 10 + result;
				carry = m / 10;
			}
			if (carry != 0) {
				result = carry + result;
			}
			if (!result.equals("0")) {
				for (int i = 0; i < offset; i++) {
					result += "0";
				}
			}
			return result;
		}
	}

	private String add(String num1, String num2) {
		String result = "";
		int i = num1.length() - 1;
		int j = num2.length() - 1;
		int carry = 0;
		while (i >= 0 || j >= 0) {
			int iValue = (i >= 0 ? (num1.charAt(i--) - '0') : 0);
			int jValue = (j >= 0 ? (num2.charAt(j--) - '0') : 0);
			int sum = iValue + jValue + carry;
			result = sum % 10 + result;
			carry = sum / 10;
		}
		if (carry != 0) {
			result = carry + result;
		}
		return result;
	}

	public static void main(String[] ags) {
		MultiplyString ms = new MultiplyString();
		System.out.println(ms.multiply("9809", "202"));
	}
}
