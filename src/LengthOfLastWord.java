/**
 * http://leetcode.com/onlinejudge#question_58
 * 
 * @author fanzhang
 * 
 */
public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
		if (s == null || s.isEmpty()) {
			return 0;
		}
		boolean space = true;
		int i;
		int wordEnd = 0;
		for (i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == ' ') {
				if (!space) {
					return wordEnd - i;
				}
			} else {
				if (space == true) {
					wordEnd = i;
					space = false;
				}
			}
		}
		if (space) {
			return 0;
		} else {
			return wordEnd + 1;
		}
	}
}
