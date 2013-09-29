import java.util.ArrayList;

public class SpiralPrint {
	/**
	 * http://leetcode.com/onlinejudge#question_54
	 */
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
			return new ArrayList<Integer>();
		}
		return print(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1);
	}

	private ArrayList<Integer> print(int[][] matrix, int top, int left, int bottom, int right) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		// top
		if (top <= bottom) {
			for (int i = left; i <= right; i++) {
				result.add(matrix[top][i]);
			}
		}
		// right
		if (right >= left) {
			for (int i = top + 1; i <= bottom; i++) {
				result.add(matrix[i][right]);
			}
		}
		// bottom
		if (bottom > top) {
			for (int i = right - 1; i >= left; i--) {
				result.add(matrix[bottom][i]);
			}
		}
		// left
		if (left < right) {
			for (int i = bottom - 1; i > top; i--) {
				result.add(matrix[i][left]);
			}
		}
		// recursion to print inner
		if (result.size() != 0) {
			result.addAll(print(matrix, top + 1, left + 1, bottom - 1, right - 1));
		}
		return result;
	}

	private int num = 0;

	/**
	 * http://leetcode.com/oldoj#question_59
	 * 
	 */
	public int[][] generateMatrix(int n) {
		num = 0;
		int[][] matrix = new int[n][n];
		generate(matrix, 0, 0, n - 1, n - 1);
		return matrix;
	}

	private void generate(int[][] matrix, int top, int left, int bottom, int right) {
		// base case check
		if (top > bottom) {
			return;
		}
		// top
		for (int i = left; i <= right; i++) {
			matrix[top][i] = ++num;
		}
		// right side
		for (int i = top + 1; i <= bottom; i++) {
			matrix[i][right] = ++num;
		}
		// bottom
		for (int i = right - 1; i >= left; i--) {
			matrix[bottom][i] = ++num;
		}
		// left side
		for (int i = bottom - 1; i > top; i--) {
			matrix[i][left] = ++num;
		}
		// recursion
		generate(matrix, top + 1, left + 1, bottom - 1, right - 1);
	}
}
