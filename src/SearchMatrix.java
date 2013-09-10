public class SearchMatrix {
	/**
	 * http://leetcode.com/onlinejudge#question_74
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null) {
			return false;
		}
		int row = matrix.length;
		int col = matrix[0].length;
		if (row == 0 || col == 0) {
			return false;
		}
		int i = 0;
		int j = col - 1;
		while (i >= 0 && i < row && j >= 0 && j < col) {
			if (matrix[i][j] == target) {
				return true;
			} else if (matrix[i][j] < target) {
				i++;
			} else {
				j--;
			}
		}
		return false;
	}
}
