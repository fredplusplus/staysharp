/**
 * http://leetcode.com/onlinejudge#question_64
 * 
 */
public class MinPathSum {
	public int minPathSum(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		int[][] cost = new int[row][col];
		cost[row - 1][col - 1] = grid[row - 1][col - 1];
		// last row
		for (int j = col - 2; j >= 0; j--) {
			cost[row - 1][j] = grid[row - 1][j] + cost[row - 1][j + 1];
		}
		// last column
		for (int i = row - 2; i >= 0; i--) {
			cost[i][col - 1] = grid[i][col - 1] + cost[i + 1][col - 1];
		}
		for (int i = row - 2; i >= 0; i--) {
			for (int j = col - 2; j >= 0; j--) {
				cost[i][j] = grid[i][j] + Math.min(cost[i + 1][j], cost[i][j + 1]);
			}
		}
		return cost[0][0];
	}
}
