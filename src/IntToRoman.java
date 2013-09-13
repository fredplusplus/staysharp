public class IntToRoman {
	private String[][] map = new String[][] { { "I", "V" }, { "X", "L" }, { "C", "D" }, { "M" } };

	/**
	 * http://leetcode.com/onlinejudge#question_12
	 */
	public String intToRoman(int num) {
		String roman = "";
		int level = 0;
		while (num > 0) {
			int digit = num % 10;
			if (digit >= 1 && digit <= 3) {
				for (int i = 0; i < digit; i++) {
					roman = map[level][0] + roman;
				}
			} else if (digit == 4) {
				roman = map[level][0] + map[level][1] + roman;
			} else if (digit == 5) {
				roman = map[level][1] + roman;
			} else if (digit >= 6 && digit <= 8) {
				String romanForThisDigit = map[level][1];
				for (int i = 5; i < digit; i++) {
					romanForThisDigit += map[level][0];
				}
				roman = romanForThisDigit + roman;
			} else if (digit == 9) {
				roman = map[level][0] + map[level + 1][0] + roman;
			}
			level++;
			num = num / 10;
		}
		return roman;
	}

	public static void main(String[] args) {
		IntToRoman itr = new IntToRoman();

		System.out.println(itr.intToRoman(61));
	}
}
