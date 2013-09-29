import java.util.HashMap;
import java.util.Map;

/**
 * http://leetcode.com/onlinejudge#question_3
 * 
 * 
 */
public class LongestSubstringWithoutRepeat {
	public int lengthOfLongestSubstring(String s) {
		int start = 0;
		int end = 0;
		int maxlength = 0;
		Map<Character, Boolean> occurred = new HashMap<Character, Boolean>();
		for (end = 0; end < s.length(); end++) {
			if (occurred.get(s.charAt(end)) == null || occurred.get(s.charAt(end)) == false) {
				occurred.put(s.charAt(end), true);
			} else {
				maxlength = Math.max(maxlength, end - start);
				while (s.charAt(start) != s.charAt(end)) {
					occurred.put(s.charAt(start++), false);
				}
				start++;
			}
		}
		return Math.max(maxlength, end - start);
	}
}
