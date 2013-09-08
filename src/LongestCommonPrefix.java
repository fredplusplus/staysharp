/**
 * http://leetcode.com/onlinejudge#question_14
 * 
 */
public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		} else if (strs.length == 1) {
			return strs[0];
		}
		String prefix = "";
		int length = Integer.MAX_VALUE;
		for (String s : strs) {
			length = Math.min(s.length(), length);
		}
		for (int i = 0; i < length; i++) {
			boolean same = true;
			char c = strs[0].charAt(i);
			for (String s : strs) {
				if (s.charAt(i) != c) {
					same = false;
					break;
				}
			}
			if (same) {
				prefix += c;
			} else {
				break;
			}
		}
		return prefix;
	}
}
