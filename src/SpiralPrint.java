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

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 2, 3, }, { 4, 5, 6 }, { 7, 8, 9 } };
		SpiralPrint sp = new SpiralPrint();
		System.out.println(sp.spiralOrder(matrix));
	}
}
