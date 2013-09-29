public class RemoveSpace {
	/**
	 * http://leetcode.com/2010/02/c-code-to-remove-spaces-from-string.html
	 */
	public int removeSpace(char[] str) {
		if (str == null || str.length == 0) {
			return 0;
		} else {
			int i = 0;
			int j = 0;
			for (j = 0; j < str.length; j++) {
				if (str[j] != ' ') {
					str[i++] = str[j];
				}
			}
			return i;
		}
	}
}
