public class UniquePath {
	/**
	 * http://leetcode.com/onlinejudge#question_62
	 * 
	 * @author fanzhang
	 * 
	 */
	public int uniquePaths(int m, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (m == 0 || n == 0) {
			return 0;
		}
		int[][] board = new int[m][n];
		for (int i = 0; i < m; i++) {
			board[i][0] = 1;
		}
		for (int j = 0; j < n; j++) {
			board[0][j] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				board[i][j] = board[i - 1][j] + board[i][j - 1];
			}
		}
		return board[m - 1][n - 1];
	}

	/**
	 * http://leetcode.com/onlinejudge#question_63
	 */
	public int uniquePathsWithObstacles(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		Integer[][] solution = new Integer[row][col];
		// init obstacles
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == 1) {
					solution[i][j] = 0;
				}
			}
		}
		if (grid[row - 1][col - 1] == 0) {
			solution[row - 1][col - 1] = 1;
		} else {
			solution[row - 1][col - 1] = 0;
		}
		// init rows
		for (int i = row - 2; i >= 0; i--) {
			if (solution[i][col - 1] == null) {
				solution[i][col - 1] = solution[i + 1][col - 1];
			}
		}
		// init cols
		for (int j = col - 2; j >= 0; j--) {
			if (solution[row - 1][j] == null) {
				solution[row - 1][j] = solution[row - 1][j + 1];
			}
		}
		// init the rest
		for (int i = row - 2; i >= 0; i--) {
			for (int j = col - 2; j >= 0; j--) {
				if (solution[i][j] == null) {
					solution[i][j] = solution[i + 1][j] + solution[i][j + 1];
				}
			}
		}
		return solution[0][0];
	}

	public static void main(String[] args) {
		UniquePath up = new UniquePath();
		System.out.println(up.uniquePathsWithObstacles(new int[][] { { 0 }, { 0 } }));
	}
}
