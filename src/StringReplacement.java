public class StringReplacement {
	/**
	 * http://leetcode.com/2010/11/microsoft-string-replacement-problem.html
	 */
	public int replace(char[] str, char[] pattern) {
		int i = 0;
		int j = 0;
		while (j < str.length) {
			boolean matched = false;
			while (isMatch(str, pattern, j)) {
				matched = true;
				j += pattern.length;
			}
			if (matched) {
				str[i++] = 'X';
			}
			if (j < str.length) {
				str[i++] = str[j++];
			}
		}
		return i;
	}

	private boolean isMatch(char[] str, char[] pattern, int start) {
		for (int i = 0; i < pattern.length; i++) {
			if (i + start >= str.length || str[i + start] != pattern[i]) {
				return false;
			}
		}
		return true;
	}
}
