public class ScrambleString {
	/**
	 * http://leetcode.com/oldoj#question_87
	 */
	public boolean isScramble(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		} else if (s1.length() == 1 && s1.charAt(0) == s2.charAt(0)) {
			return true;
		} else {
			boolean isScramble = false;
			int s1length = s1.length();
			for (int i = 1; i < s1length; i++) {
				String front1 = s1.substring(0, i);
				String back1 = s1.substring(i, s1length);
				String front2 = s2.substring(0, i);
				String back2 = s2.substring(i, s1length);
				boolean isFrontScramble = false;
				boolean isBackScramble = false;
				if (same(front1, front2)) {
					isFrontScramble = isScramble(front1, front2);
				}
				if (same(back1, back2)) {
					isBackScramble = isScramble(back1, back2);
				}
				isScramble = isFrontScramble && isBackScramble;
				if (isScramble) {
					break;
				}
				isFrontScramble = false;
				isBackScramble = false;
				front2 = s2.substring(0, back1.length());
				back2 = s2.substring(front2.length(), s1length);
				if (same(front1, back2)) {
					isFrontScramble = isScramble(front1, back2);
				}
				if (same(front2, back1)) {
					isBackScramble = isScramble(front2, back1);
				}
				isScramble = isFrontScramble && isBackScramble;
				if (isScramble) {
					break;
				}
			}
			return isScramble;
		}
	}

	private boolean same(String s1, String s2) {
		int[] map = new int[256];
		for (Character c : s1.toCharArray()) {
			map[c]++;
		}
		for (Character c : s2.toCharArray()) {
			if (--map[c] < 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		ScrambleString ss = new ScrambleString();
		System.out.println(ss.isScramble("aa", "ab"));
	}
}
