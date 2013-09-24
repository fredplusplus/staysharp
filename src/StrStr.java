public class StrStr {
	/**
	 * http://leetcode.com/oldoj#question_28
	 */
	public String strStr(String haystack, String needle) {
		if (needle.length() > haystack.length()) {
			return null;
		} else {
			int i = 0;
			int j = 0;
			for (i = 0; i <= haystack.length() - needle.length(); i++) {
				for (j = 0; j < needle.length(); j++) {
					if (haystack.charAt(i + j) != needle.charAt(j)) {
						break;
					}
				}
				if (j == needle.length()) {
					return haystack.substring(i);
				}
			}
			return null;
		}
	}

	public static void main(String[] args) {
		StrStr ss = new StrStr();
		System.out.println(ss.strStr("bblahhhh", "blah"));
	}
}
