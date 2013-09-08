/**
 * http://leetcode.com/onlinejudge#question_73
 */
public class MatrixZero {
	public void setZeroes(int[][] matrix) {
		int[] rows = new int[matrix.length];
		int[] cols = new int[matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					rows[i] = 1;
					cols[j] = 1;
				}
			}
		}
		for (int i = 0; i < rows.length; i++) {
			if (rows[i] == 1) {
				// clear row i
				for (int j = 0; j < matrix[0].length; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		for (int i = 0; i < cols.length; i++) {
			if (cols[i] == 1) {
				// clear col i
				for (int j = 0; j < matrix.length; j++) {
					matrix[j][i] = 0;
				}
			}
		}
	}

	public static void main(String[] ar) {
		MatrixZero z = new MatrixZero();
		z.setZeroes(new int[][] { { 0 } });
	}
}
