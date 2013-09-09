public class PylindromeNumber {
	/**
	 * http://leetcode.com/onlinejudge#question_9
	 */
	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		int digits = 1;
		int clone = x;
		while (clone >= 10) {
			clone = clone / 10;
			digits *= 10;
		}
		while (digits > 0) {
			int lastDigit = x % 10;
			int firstDigit = x / digits;
			if (lastDigit != firstDigit) {
				return false;
			}
			x = x % digits;
			x = x / 10;
			digits /= 100;
		}
		return true;
	}

	public static void main(String[] args) {
		PylindromeNumber pn = new PylindromeNumber();
		System.out.println(pn.isPalindrome(2147447412));
	}
}
