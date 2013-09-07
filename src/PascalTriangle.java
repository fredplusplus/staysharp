import java.util.ArrayList;

public class PascalTriangle {
	/**
	 * http://leetcode.com/onlinejudge#question_118
	 * 
	 */
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (numRows == 0) {
			return result;
		} else {
			for (int row = 0; row < numRows; row++) {
				ArrayList<Integer> rowResult = new ArrayList<Integer>();
				rowResult.add(1);
				for (int col = 0; col < row - 1; col++) {
					rowResult.add(result.get(row - 1).get(col) + result.get(row - 1).get(col + 1));
				}
				if (row > 0) {
					rowResult.add(1);
				}
				result.add(rowResult);
			}
			return result;
		}
	}

	/**
	 * http://leetcode.com/onlinejudge#question_119
	 */
	public ArrayList<Integer> getRow(int rowIndex) {
		ArrayList<Integer> currentRow = new ArrayList<Integer>();
		currentRow.add(1);
		ArrayList<Integer> previousRow = currentRow;
		if (rowIndex == 0) {
			return currentRow;
		} else {
			for (int row = 1; row <= rowIndex; row++) {
				currentRow = new ArrayList<Integer>();
				currentRow.add(1);
				for (int col = 0; col < previousRow.size() - 1; col++) {
					currentRow.add(previousRow.get(col) + previousRow.get(col + 1));
				}
				currentRow.add(1);
				previousRow = currentRow;
			}
			return currentRow;
		}
	}
}
