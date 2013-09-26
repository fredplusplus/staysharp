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

	public static void main(String[] args) {
		RemoveSpace rs = new RemoveSpace();
		char[] str = "   a c d e f    ".toCharArray();
		int size = rs.removeSpace(str);
		System.out.println(size);
		System.out.println(str);

	}
}
