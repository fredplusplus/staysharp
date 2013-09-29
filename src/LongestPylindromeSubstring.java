public class LongestPylindromeSubstring {
	/**
	 * http://leetcode.com/onlinejudge#question_5
	 */
	public String longestPalindrome(String s) {
		if (s == null || s.isEmpty()) {
			return "";
		} else {
			String longest = s.substring(0, 1);
			for (int i = 0; i < s.length() - 1; i++) {
				String even = expandAroundCenter(s, i, i + 1);
				if (even.length() > longest.length()) {
					longest = even;
				}
				String odd = expandAroundCenter(s, i, i);
				if (odd.length() > longest.length()) {
					longest = odd;
				}
			}
			return longest;
		}
	}

	private String expandAroundCenter(String s, int c1, int c2) {
		int len = s.length();
		while (c1 >= 0 && c2 < len && s.charAt(c1) == s.charAt(c2)) {
			c1--;
			c2++;
		}
		return s.substring(c1 + 1, c2);
	}
}
