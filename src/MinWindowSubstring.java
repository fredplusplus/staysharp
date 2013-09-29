public class MinWindowSubstring {
	/**
	 * http://leetcode.com/oldoj#question_76
	 */
	public String minWindow(String S, String T) {
		if (S == null || T == null) {
			return null;
		} else if (S.isEmpty() || T.isEmpty()) {
			return null;
		}
		int[] need = new int[256];
		int[] found = new int[256];
		int count = 0;
		for (Character c : T.toCharArray()) {
			need[c]++;
		}
		int maxStart = -1;
		int maxEnd = -1;
		int start = 0;
		int end = 0;
		for (end = 0; end < S.length(); end++) {
			found[S.charAt(end)]++;
			if (need[S.charAt(end)] == 0) {
				continue;
			}
			if (found[S.charAt(end)] <= need[S.charAt(end)]) {
				count++;
			}
			if (count == T.length()) {
				while (need[S.charAt(start)] == 0 || found[S.charAt(start)] > need[S.charAt(start)]) {
					if (found[S.charAt(start)] > need[S.charAt(start)]) {
						found[S.charAt(start)]--;
					}
					start++;
				}
				if (maxStart == -1 || end - start + 1 < maxEnd - maxStart + 1) {
					maxEnd = end;
					maxStart = start;
				}
			}
		}
		if (maxStart != -1) {
			return S.substring(maxStart, maxEnd + 1);
		} else {
			return "";
		}
	}
}
