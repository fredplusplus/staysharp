public class RegexMatching {
	/**
	 * http://leetcode.com/oldoj#question_10
	 */
	public boolean isMatch(String s, String p) {
		return match(s.toCharArray(), p.toCharArray(), 0, 0);
	}

	private boolean match(char[] s, char[] p, int sIndex, int pIndex) {
		if (sIndex == s.length) {
			return pIndex == p.length;
		} else if (pIndex == p.length) {
			return sIndex == s.length;
		} else {
			if (pIndex == p.length - 1 || p[pIndex + 1] != '*') {
				if (sIndex != s.length - 1) {
					return false;
				}
				return (s[sIndex] == p[pIndex] || (p[pIndex] == '.' && sIndex != s.length))
						&& match(s, p, sIndex + 1, pIndex + 1);
			} else {
				while (sIndex < s.length && (s[sIndex] == p[pIndex] || (p[pIndex] == '.' && sIndex != s.length))) {
					if (match(s, p, sIndex, pIndex + 2)) {
						return true;
					}
					sIndex++;
				}
				return match(s, p, sIndex, pIndex + 2);
			}
		}
	}
}
