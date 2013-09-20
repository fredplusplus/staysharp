public class EditDistance {
	/**
	 * http://leetcode.com/oldoj#question_72
	 */
	public int minDistance(String word1, String word2) {
		char[] str1 = word1.toCharArray();
		char[] str2 = word2.toCharArray();
		if (str1.length == 0) {
			return str2.length;
		} else if (str2.length == 0) {
			return str1.length;
		} else {
			int[][] result = new int[str1.length + 1][str2.length + 1];
			for (int i = 1; i <= str2.length; i++) {
				result[0][i] = result[0][i - 1] + 1;
			}
			for (int i = 1; i <= str1.length; i++) {
				result[i][0] = result[i - 1][0]+1;
			}
			for (int i = 1; i <= str1.length; i++) {
				for (int j = 1; j <= str2.length; j++) {
					int modifyCost = result[i - 1][j - 1] + (str1[i - 1] == str2[j - 1] ? 0 : 1);
					result[i][j] = Math.min(result[i][j - 1] + 1, Math.min(modifyCost, result[i - 1][j] + 1));
				}
			}
			return result[str1.length][str2.length];
		}
	}

	public static void main(String[] args) {
		EditDistance dis = new EditDistance();

		System.out.println(dis.minDistance("ab", "bc"));
	}
}
