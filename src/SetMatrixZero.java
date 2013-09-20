public class SetMatrixZero {
	/**
	 * http://leetcode.com/oldoj#question_73
	 */
	public void setZeroes(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
			return;
		}
		int[] zeroRow = new int[matrix.length];
		int[] zeroCol = new int[matrix[0].length];
		for (int i = 0; i < zeroRow.length; i++) {
			for (int j = 0; j < zeroCol.length; j++) {
				if (matrix[i][j] == 0) {
					zeroRow[i] = 1;
					zeroCol[j] = 1;
				}
			}
		}
		for (int i = 0; i < zeroRow.length; i++) {
			if (zeroRow[i] == 1) {
				clearRow(matrix, i);
			}
		}
		for (int i = 0; i < zeroCol.length; i++) {
			if (zeroCol[i] == 1) {
				clearCol(matrix, i);
			}
		}
	}

	private void clearRow(int[][] matrix, int row) {
		for (int i = 0; i < matrix[0].length; i++) {
			matrix[row][i] = 0;
		}
	}

	private void clearCol(int[][] matrix, int col) {
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][col] = 0;
		}
	}

	public static void main(String[] args) {
		SetMatrixZero smz = new SetMatrixZero();

		smz.setZeroes(new int[][] { { 1, 0 } });
	}
}
