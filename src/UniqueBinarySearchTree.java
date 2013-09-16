public class UniqueBinarySearchTree {
	/**
	 * http://leetcode.com/oldoj#question_96
	 */
	public int numTrees(int n) {
		// catalan number
		int c = 1;
		for (int i = 2; i <= n; i++) {
			c = 2 * (2 * i - 1) * c / (i + 1);
		}
		return c;
	}
}
